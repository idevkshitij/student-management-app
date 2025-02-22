// src/components/Navbar/Navbar.js
import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext";
import styles from "./Navbar.module.css";

const Navbar = () => {
  const { isAuthenticated, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    const confirmLogout = window.confirm("Are you sure you want to log out?");
    if (confirmLogout) {
      logout(); // Clear the token from context and localStorage
      navigate("/login"); // Redirect to the login page
    }
  };

  return (
    <nav className={styles.navbar}>
      <div className={styles.brand}>
        <Link to="/view-students">Student Management Application</Link>
      </div>
      <div className={styles.links}>
        {isAuthenticated ? (
          <>
            <Link to="/add-student">Add Student</Link>
            <Link to="/view-students">View Students</Link>
            <button
              style={{ color: "red" }}
              onClick={handleLogout}
              className={styles.logoutButton}
            >
              Logout
            </button>
          </>
        ) : (
          <Link to="/login" style={{ color: "#219de1" }}>
            Welcome To Kshitij's Assignment
          </Link>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
