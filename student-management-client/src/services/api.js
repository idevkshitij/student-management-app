import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
});

// Add a request interceptor to include Basic Authentication for specific endpoints
api.interceptors.request.use(
  (config) => {
    // Define the endpoints that require Basic Authentication
    // const basicAuthEndpoints = [
    //   { method: "POST", url: "/api/students" },
    //   { method: "PUT", url: "/api/students/**" },
    //   { method: "DELETE", url: "/api/students/**" },
    // ];

    // // Check if the request matches any of the secured endpoints
    // const isBasicAuthRequired = basicAuthEndpoints.some((endpoint) => {
    //   const methodMatches = config.method.toUpperCase() === endpoint.method;
    //   const urlMatches = new RegExp(
    //     `^${endpoint.url.replace(/\*\*/g, ".*")}$`
    //   ).test(config.url);
    //   return methodMatches && urlMatches;
    // });

    // if (isBasicAuthRequired) {
    //   const username = "admin"; // Replace with your username
    //   const password = "password"; // Replace with your password
    //   const encodedCredentials = btoa(`${username}:${password}`); // Base64 encode the credentials
    //   config.headers.Authorization = `Basic ${encodedCredentials}`; // Add Basic Authentication header
    // }

    // Check if a JWT token is available and add it to the request
    const token = localStorage.getItem("token");
    if (token) {
      console.log("token set");
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    console.error("Request interceptor error:", error);
    return Promise.reject(error);
  }
);

// Add a response interceptor to handle errors globally
api.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    if (error.response) {
      // Handle specific HTTP error statuses
      switch (error.response.status) {
        case 401:
          console.error("Unauthorized: Please log in again.");
          // Redirect to login page or refresh token
          break;
        case 403:
          console.error(
            "Forbidden: You do not have permission to access this resource."
          );
          break;
        case 404:
          console.error("Not Found: The requested resource does not exist.");
          break;
        case 500:
          console.error("Server Error: Something went wrong on the server.");
          break;
        default:
          console.error(
            "An error occurred:",
            error.response.data || error.message
          );
      }
    } else if (error.request) {
      console.error("No response received:", error.request);
    } else {
      console.error("Request setup error:", error.message);
    }
    return Promise.reject(error);
  }
);

export default api;
