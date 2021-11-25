package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/timetable")
public class TimetableController
{
    @Autowired
    TimetableService timetableService;

    @PostMapping("/saveStu")
    @ResponseBody
    public Object saveStuTimetable(@RequestBody Map<String, Object> info)
    {
        Map<String, List<String>> timetable = (Map<String, List<String>>) info.get("timetable");
        System.out.println(timetable.get("tue").get(1));
        return null;
    }
}
