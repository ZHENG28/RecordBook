package com.example.records.demo.DemoApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Student;

public interface StudentRepository extends JpaRepository<Student,String>{
	Optional<Student> findByUsername(String username);
}
