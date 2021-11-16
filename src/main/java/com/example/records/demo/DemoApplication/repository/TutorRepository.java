package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor,Long>{

}
