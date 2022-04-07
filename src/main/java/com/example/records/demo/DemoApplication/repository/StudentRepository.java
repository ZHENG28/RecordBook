package com.example.records.demo.DemoApplication.repository;

import java.util.List;
import java.util.Optional;

import com.example.records.demo.DemoApplication.entity.CClass;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.Student;

import javax.swing.text.html.Option;

public interface StudentRepository extends JpaRepository<Student, String>
{
    Optional<Student> findByUsername(String username);

    List<Student> findAllByCclass(CClass cclass);

	Optional<Student> findById(Long id);
}
