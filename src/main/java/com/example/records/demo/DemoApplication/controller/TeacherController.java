package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import com.example.records.demo.DemoApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TeacherController
{
    @Autowired
    CClassRepository classRepo;

    @Autowired
    TeacherService teacherService;

    //dark
    //teacher主页
    @GetMapping("/teacherIndex_dark")
    public String teacherIndex_dark()
    {
        return "/teacher/teacherIndex";
    }

    //进入亮模式
    @GetMapping("/toLight")
    public String toLight()
    {
        return "/teacher/layout-sidenav-light";
    }


    //light
    //进入暗模式
    @GetMapping("/toDark")
    public String toDark()
    {
        return "/teacher/layout-static";
    }


    //查询功能
    //查看所有班级
    @GetMapping("/queryTotalClass")
    @ResponseBody
    public Object queryTotalClass()
    {
        Map<String, Object> totalclass = new HashMap<>();
        List<String> classname = new ArrayList<String>();
        for (CClass classes : classRepo.findAll()){
            classname.add(classes.getClassName());
        }
        totalclass.put("data",classname);
        return totalclass;
    }

    //查看班级学生
    @GetMapping("/queryClass")
    public String queryClass(Model model, @RequestParam(name = "classId") Long classId)
    {
        Optional<CClass> cClass = classRepo.findById(classId);
        Set<Student> students = cClass.get().getStudents();
        model.addAttribute("class", cClass.get());
        model.addAttribute("students", students);
        return "teacher/classStudent";
    }

    //查询某个班的CET信息
    @PostMapping("/queryCET46")
    @ResponseBody
    public Map<String, Integer> queryCET46(@RequestBody Map<String, String> queryinfo)
    {
        String grade = queryinfo.get("grade");
        String classname = queryinfo.get("classname");

        Map<String, Integer> response = new HashMap<>();
        int[] cetList = teacherService.getCet(grade, classname);
        response.put("CET4", cetList[0]);
        response.put("CET6", cetList[1]);
        response.put("total", cetList[2]);
        return response;
    }
}
