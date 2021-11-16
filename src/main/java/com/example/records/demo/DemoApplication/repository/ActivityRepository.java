package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Long>{

}
