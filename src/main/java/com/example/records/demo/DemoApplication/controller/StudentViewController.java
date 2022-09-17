package com.example.records.demo.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentViewController {

    @GetMapping("/Schedule")
    public String Schedule(){
        return "student/views/Schedule";
    }

    @GetMapping("/project")
    public String Project(){
        return "student/views/project";
    }

    @GetMapping("/editInformation")
    public String EditInformation(){return "student/views/editStudentInformation";}
    
}
