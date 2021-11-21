package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.CClass;

import java.util.List;

public interface CClassRepository extends JpaRepository<CClass, Long>
{
    List<CClass> findByClassNameLike(String grade);
}
