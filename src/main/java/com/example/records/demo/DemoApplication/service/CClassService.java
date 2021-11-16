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

    public Set<String> getAllGrade()
    {
        List<CClass> classList = cclassRepo.findAll();
        Set<String> grades = new HashSet<>();

        for (CClass c : classList) {
            grades.add("20" + c.getClass_name().substring(c.getClass_name().length() - 2));
        }

        return grades;
    }

    public List<String> getClassByGrade(String grade)
    {
//        List<CClass> classList = cclassRepo.findByClass_nameLike("%" + grade.substring(2));
//        System.out.println(classList);
        return null;
    }
}
