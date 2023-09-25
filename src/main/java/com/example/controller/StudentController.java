package com.example.controller;

import com.example.entity.Student;
import com.example.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        Student insertedStudent= studentServiceImpl.insertStudent(student);
        return ResponseEntity.ok(insertedStudent);
    }
}