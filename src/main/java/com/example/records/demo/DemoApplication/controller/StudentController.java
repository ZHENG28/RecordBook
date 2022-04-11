package com.example.records.demo.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	//学生主页内容加载
    @GetMapping("/studentIndexContent")
    public String StudentIndexContent(){
        return "student/views/studentIndex";
    }
}
