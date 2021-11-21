package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CClassService
{
    @Autowired
    CClassRepository cclassRepo;
}
