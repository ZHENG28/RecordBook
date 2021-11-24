package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.Project;
import com.example.records.demo.DemoApplication.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController
{
    @Autowired
    ProjectService projectService;

    @PostMapping("/queryStuProject")
    @ResponseBody
    public Object queryStuProject(String classname)
    {
        List<Project> projects = projectService.queryStuProject(classname);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Project p : projects) {
            Map<String, Object> res = new HashMap<>();
            res.put("time", p.getTime());
            res.put("ranking", p.getRanking());
            res.put("name", p.getName());
            res.put("student", p.getStudent().getName());
            response.add(res);
        }

        return response;
    }
}
