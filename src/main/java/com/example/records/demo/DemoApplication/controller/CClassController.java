package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.service.CClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CClassController
{
    @Autowired
    CClassService classService;

    @GetMapping("/getAllGrade")
    @ResponseBody
    public Object getAllGrade()
    {
        return classService.getAllGrade();
    }

    @GetMapping("/getClassByGrade")
    @ResponseBody
    public Object getClassByGrade(String grade)
    {
        return classService.getClassByGrade(grade);
    }
}
