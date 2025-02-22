import React, { useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext";
import api from "../../services/api";
import styles from "./ViewAndDeleteStudent.module.css";

const ViewAndDeleteStudent = () => {
  const [students, setStudents] = useState([]);
  const { token } = useContext(AuthContext);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const response = await api.get("/api/students", {});
        setStudents(response.data);
      } catch (error) {
        console.error(
          "Failed to fetch students:",
          error.response?.data || error.message
        );

        // Handle 403 Forbidden error
        if (error.response?.status === 403) {
          navigate("/login"); // Redirect to the login page
        }
      }
    };
    fetchStudents();
  }, []);

  const handleEdit = (id) => {
    const confirmEdit = window.confirm(
      "Are you sure you want to edit this student?"
    );
    if (confirmEdit) {
      navigate(`/edit-student/${id}`); // Navigate to the edit page
    }
  };

  const handleDelete = async (id) => {
    const confirmDelete = window.confirm(
      "Are you sure you want to delete this student?"
    );
    if (confirmDelete) {
      try {
        const student = students.find((student) => student.id === id);
        await api.delete(`/api/students/${id}`);
        setStudents(students.filter((student) => student.id !== id));
        alert(`Student ${student.name} successfully deleted!`); // Alert for successful deletion with student name
      } catch (error) {
        console.error(
          "Failed to delete student:",
          error.response?.data || error.message
        );
      }
    }
  };

  return (
    <div className={styles.container}>
      <h1>Students Stored List</h1>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Class</th>
            <th>Phone Number</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.age}</td>
              <td>{student.className}</td>
              <td>{student.phoneNumber}</td>
              <td>
                <button
                  onClick={() => handleEdit(student.id)} // Handle edit on click
                  className={styles.editButton}
                >
                  Edit
                </button>
                <button
                  onClick={() => handleDelete(student.id)}
                  className={styles.deleteButton}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ViewAndDeleteStudent;
