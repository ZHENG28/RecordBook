package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.LoginedUser;
import com.example.records.demo.DemoApplication.entity.Project;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.service.ProjectService;
import com.example.records.demo.DemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    StudentService studentService;

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

    @PostMapping("/saveStu")
    @ResponseBody
    public Object saveStuProject(@RequestBody Map<String, Object> info)
    {
        List<Map<String, Object>> projects = (List<Map<String, Object>>) info.get("projects");
        Student stu = studentService.findStuByName((String) LoginedUser.INFO.get("username"));

        List<Project> projectList = new ArrayList<>();
        for (Map<String, Object> map : projects) {
            Project p = new Project();
            p.setName(String.valueOf(map.get("name")));
            p.setTime(String.valueOf(map.get("time")));
            p.setRanking(String.valueOf(map.get("rank")));
            p.setStudent(stu);
            projectList.add(p);
        }
        return projectService.saveStuProject(projectList);
    }
}
