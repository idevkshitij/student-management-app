package com.kshitij.studentmanagement.api;

import com.kshitij.studentmanagement.model.Student;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface StudentApiDelegate {
    ResponseEntity<Student> addStudent(Student student);

    ResponseEntity<List<Student>> getAllStudents();

    ResponseEntity<Student> getStudentById(Integer id);

    ResponseEntity<Student> updateStudent(Integer id, Student student);

    ResponseEntity<Void> deleteStudent(Integer id);
}