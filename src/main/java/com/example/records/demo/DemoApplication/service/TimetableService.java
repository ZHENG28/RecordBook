package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.entity.Timetable;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import com.example.records.demo.DemoApplication.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    @Autowired
    TimetableRepository timetableRepo;

    @Autowired
    StudentRepository studentRepo;

    public Object saveStuTimetable(int id, Timetable timetable)
    {
        Student stu = studentRepo.findById((long) id).orElseThrow();
        if (stu.getTimetable() != null) {
            timetable.setId(stu.getTimetable().getId());
        }
        stu.setTimetable(timetable);
        return studentRepo.save(stu);
    }

    public Object getIdleTimetable(long id)
    {
        int[][] mapData = new int[7*13][3];
        Timetable t = timetableRepo.findById(id).get();

        mapData = addOneDay(mapData, t.getClassing().substring(0,13), "mon");
        mapData = addOneDay(mapData, t.getClassing().substring(13,26), "tue");
        mapData = addOneDay(mapData, t.getClassing().substring(26,39), "wed");
        mapData = addOneDay(mapData, t.getClassing().substring(39,52), "thu");
        mapData = addOneDay(mapData, t.getClassing().substring(52,65), "fri");
        mapData = addOneDay(mapData, t.getClassing().substring(65,78), "sat");
        mapData = addOneDay(mapData, t.getClassing().substring(78,91), "sun");

        return mapData;
    }

    public int[][] addOneDay(int[][] arr, String str, String day)
    {
        int d = 0;
        switch (day) {
            case "mon":
                d = 0;
                break;
            case "tue":
                d = 1;
                break;
            case "wed":
                d = 2;
                break;
            case "thu":
                d = 3;
                break;
            case "fri":
                d = 4;
                break;
            case "sat":
                d = 5;
                break;
            case "sun":
                d = 6;
                break;
        }
        String[] data = str.split(",");

        for (int c = 0; c < data.length; c++) {
            int index = d * 13 + c;
            arr[index][0] = d;
            arr[index][1] = c;
            arr[index][2] += 1 - Integer.parseInt(data[c]);
        }

        return arr;
    }
}
