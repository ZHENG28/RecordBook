package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.CClass;

import java.util.List;
import java.util.Optional;

public interface CClassRepository extends JpaRepository<CClass, Long>
{
    List<CClass> findByClassNameLike(String grade);

    Optional<CClass> findByClassName(String classname);
}
