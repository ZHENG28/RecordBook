package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.repository.SgradeRepository;
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

    @Autowired
    SgradeRepository sgradeRepository;

    public Object addClass(String grade, String classname)
    {
        CClass c = new CClass();
        c.setClassName(classname);
        c.setSgrade(sgradeRepository.findByGradeName(grade).get(0));
        return cclassRepo.save(c);
    }
}
