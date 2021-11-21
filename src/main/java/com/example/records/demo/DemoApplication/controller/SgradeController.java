package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.service.SgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sgrade")
public class SgradeController
{
    @Autowired
    SgradeService sgradeService;

    @GetMapping("/getAllGrade")
    @ResponseBody
    public Object getAllGrade()
    {
        Map<String, Object> grades = new HashMap<>();
        grades.put("data", sgradeService.getAllGrade());
        return grades;
    }

    @GetMapping("/getClassByGrade")
    @ResponseBody
    public Object getClassByGrade(String grade)
    {
        Map<String, List<String>> grades = new HashMap<>();
        grades.put("data", sgradeService.getClassByGrade(grade.substring(2, 4)));
        return grades;
    }

    @GetMapping("/addSgrade")
    public Object addSgrade(String sgrade)
    {
        return sgradeService.addSgrade(sgrade);
    }
}
