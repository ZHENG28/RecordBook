package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.repository.StudentRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    //学生主页内容加载
    @GetMapping("/studentIndexContent")
    public String StudentIndexContent(Authentication authentication, HttpSession session) {
        String studentid = studentRepository.findByUsername(authentication.getName()).get().getId().toString();
        session.setAttribute("studentid",studentid);
        return "student/views/studentIndex";
    }
}
