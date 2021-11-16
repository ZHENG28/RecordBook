package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{

}
