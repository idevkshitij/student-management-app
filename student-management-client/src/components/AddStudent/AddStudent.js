import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";
import styles from "./AddStudent.module.css";

const AddStudent = () => {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [currentClassName, setCurrentClassName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const navigate = useNavigate();

  const validateForm = () => {
    // Validate Name
    if (!name.trim()) {
      window.alert("Name is required.");
      return false;
    }

    // Validate Age
    if (!age || isNaN(age) || Number(age) <= 0) {
      window.alert("Age must be a valid number greater than 0.");
      return false;
    }

    // Validate Class Name
    if (!currentClassName.trim()) {
      window.alert("Class Name is required.");
      return false;
    }

    // Validate Phone Number
    const phoneRegex = /^\d{10}$/; // 10-digit phone number
    if (!phoneRegex.test(phoneNumber)) {
      window.alert("Phone Number must be a valid 10-digit number.");
      return false;
    }

    return true; // All validations passed
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validate the form
    if (!validateForm()) {
      return; // Stop if validation fails
    }

    try {
      const response = await api.post("/api/students", {
        name: name,
        age: age,
        className: currentClassName,
        phoneNumber: phoneNumber,
      });
      if (response.data) {
        navigate("/view-students"); // Redirect to the students list
      }
    } catch (error) {
      console.error(
        "Failed to add student:",
        error.response?.data || error.message
      );
    }
  };

  return (
    <div className={styles.addStudentContainer}>
      <h1>Add Student</h1>
      <form onSubmit={handleSubmit} className={styles.addStudentForm}>
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          className={styles.inputField}
        />
        <input
          type="number"
          placeholder="Age"
          value={age}
          onChange={(e) => setAge(e.target.value)}
          className={styles.inputField}
        />
        <input
          type="text"
          placeholder="Class"
          value={currentClassName}
          onChange={(e) => setCurrentClassName(e.target.value)}
          className={styles.inputField}
        />
        <input
          type="text"
          placeholder="Phone Number"
          value={phoneNumber}
          onChange={(e) => setPhoneNumber(e.target.value)}
          className={styles.inputField}
        />
        <button type="submit" className={styles.submitButton}>
          Add Student
        </button>
      </form>
    </div>
  );
};

export default AddStudent;
