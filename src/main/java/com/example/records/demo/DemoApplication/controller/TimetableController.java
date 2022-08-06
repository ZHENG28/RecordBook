package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.LoginedUser;
import com.example.records.demo.DemoApplication.entity.Timetable;
import com.example.records.demo.DemoApplication.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/timetable")
public class TimetableController {
    @Autowired
    TimetableService timetableService;

    @PostMapping("/saveStu")
    @ResponseBody
    public Object saveStuTimetable(@RequestBody Map<String, Object> info) {
        Map<String, ArrayList<Integer>> tt = (Map<String, ArrayList<Integer>>) info.get("timetable");
        //存储每日课程情况
        List<String> classInformation = new ArrayList<>();
        classInformation.add(StringUtils.join(tt.get("mon"), ""));
        classInformation.add(StringUtils.join(tt.get("tue"), ""));
        classInformation.add(StringUtils.join(tt.get("wed"), ""));
        classInformation.add(StringUtils.join(tt.get("thu"), ""));
        classInformation.add(StringUtils.join(tt.get("fri"), ""));
        classInformation.add(StringUtils.join(tt.get("sat"), ""));
        classInformation.add(StringUtils.join(tt.get("sun"), ""));
        Timetable timetable = new Timetable();
        //课程序列
        String classing = StringUtils.join(classInformation, "");
        timetable.setClassing(classing);

        return timetableService.saveStuTimetable((String) LoginedUser.INFO.get("username"), timetable);
    }

    @PostMapping("/getTableData")
    @ResponseBody
    public Object getStuTableData(@RequestBody Map<String, Object> info) {
        return timetableService.getStuTableData((String) LoginedUser.INFO.get("username"));
    }

    @RequestMapping("/getIdle")
    @ResponseBody
    public Object getIdle() {
        return timetableService.getIdleTimetable(1);
    }
}
