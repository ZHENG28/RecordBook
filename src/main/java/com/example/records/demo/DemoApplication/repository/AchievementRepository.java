package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement,Long>{

}
