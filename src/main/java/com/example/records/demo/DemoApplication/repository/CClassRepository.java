package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.CClass;

public interface CClassRepository extends JpaRepository<CClass,Long>{
	
}
