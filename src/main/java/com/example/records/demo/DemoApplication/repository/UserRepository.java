package com.example.records.demo.DemoApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.CUser;

public interface UserRepository extends JpaRepository<CUser,Long>{
	Optional<CUser> findByUsername(String username);
}
