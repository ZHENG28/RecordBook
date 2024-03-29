package com.example.records.demo.DemoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherViewController {

    @GetMapping("/views/cet46")
    public String cet(){
        return "teacher/views/cet46";
    }

    @GetMapping("/views/project")
    public String project(){
        return "teacher/views/project";
    }

    @GetMapping("views/index")
    public String index(){
        return "teacher/views/index";
    }

    @GetMapping("/views/totalClass")
    public String totalClass(){
        return "teacher/views/totalClass";
    }

    @PostMapping("/views/classStudent")
    public String classStudent(@RequestParam String className, HttpSession session){
        session.setAttribute("className",className);
        return "teacher/views/classStudent";}
    @GetMapping("/views/timetable")
    public String timetable(){
        return "teacher/views/timetable";
    }

    @GetMapping("/views/createactivity")
    public String create_activity(){
        return "teacher/views/create-activity";
    }
}
