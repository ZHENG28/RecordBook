package com.example.records.demo.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    String v = "admin/views/";

    @GetMapping("/")
    public String defaultview(){
        return "admin/adminindex";
    }

    @GetMapping("/views/index")
    public String index(){
        return v+"index";
    }

    @GetMapping("/views/addCclass")
    public String addCclass(){
        return v+"addCclass";
    }

    @GetMapping("/views/addGrades")
    public String addGrades(){
        return v+"addGrades";
    }

    @GetMapping("/views/addStudents")
    public String addStudents(){
        return v+"addStudent";
    }

    @GetMapping("/views/addTeacher")
    public  String addTeacher(){
        return v+"addTeacher";
    }
}
