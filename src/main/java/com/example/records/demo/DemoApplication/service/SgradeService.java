package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Sgrade;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.repository.SgradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SgradeService
{
    @Autowired
    SgradeRepository sgradeRepository;

    @Autowired
    CClassRepository cclassRepository;

    public List<String> getAllGrade()
    {
        List<String> gradeList = new ArrayList<>();
        for (Sgrade g : sgradeRepository.findAllByOrderByGradeName()) {
            gradeList.add(g.getGradeName());
        }
        return gradeList;
    }

    public List<String> getClassByGrade(String grade)
    {
        List<String> classList = new ArrayList<>();
        for (CClass c : cclassRepository.findByClassNameLike("%" + grade)) {
            classList.add(c.getClassName());
        }
        return classList;
    }
}
