package com.example.records.demo.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherViewController {

    @GetMapping("/cet46")
    public String cet(){
        return "teacher/views/cet46";
    }

    @GetMapping("/index")
    public String index(){
        return "teacher/view/index";
    }
}
