const fs = require("fs-extra");
const path = require("path");

// Source: React build folder
const buildDir = path.join(__dirname, "build");

// Destination: Spring Boot static folder
const staticDir = path.join(__dirname, "../src/main/resources/static");

// Copy the build folder to the static folder
fs.copy(buildDir, staticDir)
  .then(() => console.log("Build folder copied to Spring Boot static folder!"))
  .catch((err) => console.error("Error copying build folder:", err));
