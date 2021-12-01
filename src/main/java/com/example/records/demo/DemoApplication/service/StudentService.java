package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public Student findStuById(Long stuId)
    {
        return studentRepository.findById(stuId).orElseThrow();
    }
}
