package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.LearningRecords;

public interface LearningRecordsRepository extends JpaRepository<LearningRecords,Long>{

}
