package com.example.records.demo.DemoApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.records.demo.DemoApplication.repository.CClassRepository;

@Service
public class CClassService {
	@Autowired
	CClassRepository cclassRepo;
}
