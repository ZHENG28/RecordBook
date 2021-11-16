package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable,Long>{

}
