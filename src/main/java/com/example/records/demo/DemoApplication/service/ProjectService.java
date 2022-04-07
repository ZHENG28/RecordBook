package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Project;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.records.demo.DemoApplication.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    CClassRepository classRepo;

    @Autowired
    StudentRepository studentRepo;

    public List<Project> queryStuProject(String classname)
    {
        List<Project> projects = new ArrayList<>();

        CClass c = classRepo.findByClassName(classname).orElseThrow();
        List<Student> stuList = studentRepo.findAllByCclass(c);
        for (Student stu : stuList) {
            projects.addAll(projectRepo.findByStudent(stu));
        }

        return projects;
    }

    public void saveStuProject(List<Project> projectList)
    {
        System.out.println(projectRepo.saveAll(projectList));
    }
}
