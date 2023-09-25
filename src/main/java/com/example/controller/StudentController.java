package com.example.controller;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());

        studentRepository.save(existingStudent);
        return ResponseEntity.ok(existingStudent);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
