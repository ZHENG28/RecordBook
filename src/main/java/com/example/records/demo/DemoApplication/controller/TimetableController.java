package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.Timetable;
import com.example.records.demo.DemoApplication.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.thymeleaf.util.StringUtils;

import java.util.*;

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
        Map<String, ArrayList<Integer>> tt = (Map<String, ArrayList<Integer>>) info.get("timetable");
        int stuId = (int) info.get("student");

        Timetable timetable = new Timetable();
        timetable.setMon(StringUtils.join(tt.get("mon"), ","));
        timetable.setTue(StringUtils.join(tt.get("tue"), ","));
        timetable.setWed(StringUtils.join(tt.get("wed"), ","));
        timetable.setThu(StringUtils.join(tt.get("thu"), ","));
        timetable.setFri(StringUtils.join(tt.get("fri"), ","));
        timetable.setSat(StringUtils.join(tt.get("sat"), ","));
        timetable.setSun(StringUtils.join(tt.get("sun"), ","));

        return timetableService.saveStuTimetable(stuId, timetable);
    }

    @RequestMapping("/getIdle")
    @ResponseBody
    public Object getIdle()
    {
        return timetableService.getIdleTimetable();
    }
}
