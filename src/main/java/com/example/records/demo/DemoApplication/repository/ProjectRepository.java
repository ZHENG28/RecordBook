package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

}
