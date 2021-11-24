package com.example.records.demo.DemoApplication.repository;

import com.example.records.demo.DemoApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
    List<Project> findByStudent(Student stu);
}
