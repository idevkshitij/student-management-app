// src/App.js
import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { AuthProvider } from "./context/AuthContext";
import Navbar from "./components/Navbar/Navbar";
import Login from "./components/Login/Login";
import ViewAndDeleteStudent from "./components/ViewAndDeleteStudent/ViewAndDeleteStudent";
import AddStudent from "./components/AddStudent/AddStudent";
import EditStudent from "./components/EditStudent/EditStudent";
import "./styles/global.css";

const App = () => {
  return (
    <AuthProvider>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/view-students" element={<ViewAndDeleteStudent />} />
          <Route path="/add-student" element={<AddStudent />} />
          <Route path="/edit-student/:id" element={<EditStudent />} />
          <Route path="/" element={<Login />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
};

export default App;
