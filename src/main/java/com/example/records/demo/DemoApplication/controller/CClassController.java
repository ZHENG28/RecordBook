package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.service.CClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cclass")
public class CClassController
{
    @Autowired
    CClassService classService;
    @Autowired
    CClassRepository cClassRepository;

    @GetMapping("/addClass")
    @ResponseBody
    public Object addClass(String grade, String classname)
    {
        return classService.addClass(grade, classname);
    }

    //测试调用班级人数存储过程（要删掉的）
    @GetMapping("/classStudentNumber")
    @ResponseBody
    public Map<String, Integer> ClassStudentNumber(){
        String bb = "计师19";
        System.out.println(cClassRepository.callStoreProcess(bb));
        Map<String, Integer> response = new HashMap<>();
        response.put("班级人数",cClassRepository.callStoreProcess(bb));
        return response;
    }
    //测试
    @GetMapping("/classStudentTest")
    @ResponseBody
    public Map<String, List> ClassStudentTest(){
        String bb="计师19";
        Map<String, List> response = new HashMap<>();
        System.out.println(cClassRepository.callStoreProcess2(bb));
        response.put("班级人数",cClassRepository.callStoreProcess2(bb));
        return response;
    }



}
