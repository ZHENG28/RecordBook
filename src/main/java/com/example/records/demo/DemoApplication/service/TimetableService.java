package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.entity.Timetable;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import com.example.records.demo.DemoApplication.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TimetableService {
    @Autowired
    TimetableRepository timetableRepo;

    @Autowired
    StudentRepository studentRepo;

    public Object saveStuTimetable(String username, Timetable timetable) {
        Student stu = studentRepo.findByUsername(username).orElseThrow();
        if (stu.getTimetable() != null) {
            timetable.setId(stu.getTimetable().getId());
        }
        stu.setTimetable(timetable);
        return studentRepo.save(stu);
    }

    public Object getStuTableData(String username) {
        Student stu = studentRepo.findByUsername(username).orElseThrow();
        return stu.getTimetable().getClassing();
    }

    public Object getIdleTimetable(long id) {
        final int CLASS_NUMBER = 13;
        int[][] mapData = new int[7 * 13][3];
        //        Timetable t = timetableRepo.findById(id).get();
        List<Timetable> timetableList = timetableRepo.findAll();

        //        String[] days = new String[]{"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
        //        mapData = addOneDay(mapData, t.getClassing().substring(0, 13), "mon");
        //        mapData = addOneDay(mapData, t.getClassing().substring(13, 26), "tue");
        //        mapData = addOneDay(mapData, t.getClassing().substring(26, 39), "wed");
        //        mapData = addOneDay(mapData, t.getClassing().substring(39, 52), "thu");
        //        mapData = addOneDay(mapData, t.getClassing().substring(52, 65), "fri");
        //        mapData = addOneDay(mapData, t.getClassing().substring(65, 78), "sat");
        //        mapData = addOneDay(mapData, t.getClassing().substring(78, 91), "sun");

        for (Timetable timetable : timetableList) {
            for (int i = 0; i < 7; i++) {
                mapData = addOneDay(mapData, timetable.getClassing().substring(CLASS_NUMBER * i, CLASS_NUMBER * (i + 1)), i);
            }
        }

        return mapData;
    }

    public int[][] addOneDay(int[][] arr, String str, Integer day) {
        //        int d = 0;
        //        switch (day) {
        //            case "mon":
        //                d = 0;
        //                break;
        //            case "tue":
        //                d = 1;
        //                break;
        //            case "wed":
        //                d = 2;
        //                break;
        //            case "thu":
        //                d = 3;
        //                break;
        //            case "fri":
        //                d = 4;
        //                break;
        //            case "sat":
        //                d = 5;
        //                break;
        //            case "sun":
        //                d = 6;
        //                break;
        //        }
        //        String[] data = str.split(",");

        for (int c = 0; c < str.length(); c++) {
            int index = day * 13 + c;
            arr[index][0] = day;
            arr[index][1] = c;
            arr[index][2] += 1 - Integer.parseInt(str.substring(c, c + 1));
        }

        return arr;
    }
}
