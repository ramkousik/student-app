package com.example.service.impl;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }
}
