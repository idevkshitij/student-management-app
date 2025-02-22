package com.kshitij.studentmanagement.api;

import com.kshitij.studentmanagement.model.Student;
import com.kshitij.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentApiDelegateImpl implements StudentApiDelegate {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Student> addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(201).body(savedStudent);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id.longValue());
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Student> updateStudent(Integer id, Student student) {
        if (studentRepository.existsById(id.longValue())) {
            student.setId(id.longValue());
            return ResponseEntity.ok(studentRepository.save(student));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Integer id) {
        if (studentRepository.existsById(id.longValue())) {
            studentRepository.deleteById(id.longValue());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}