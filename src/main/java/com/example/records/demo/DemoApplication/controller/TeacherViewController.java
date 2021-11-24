package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

}
