package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.service.CClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cclass")
public class CClassController
{
    @Autowired
    CClassService classService;

    @GetMapping("/addClass")
    @ResponseBody
    public Object addClass(String grade, String classname)
    {
        return classService.addClass(grade, classname);
    }
}
