package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.records.demo.DemoApplication.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService
{
    @Autowired
    TeacherRepository teacherRepo;

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    CClassRepository cclassRepository;

    public int[] getCet(String grade, String classname)
    {
        List<Student> studentList = new ArrayList<>();
        if ("请选择班级".equals(classname)) { // 查找整个年级
            List<CClass> classList = cclassRepository.findByClassNameLike("%" + grade.substring(2, 4));
            for (CClass c : classList) {
                studentList = studentRepo.findAllByCclass(c);
            }
        } else { // 查找单个班级
            CClass c = cclassRepository.findByClassName(classname).orElseThrow();
            studentList = studentRepo.findAllByCclass(c);
        }

        int[] cetList = {0, 0, 0};
        for (Student stu : studentList) {
            switch (stu.getCet()) {
                case 0:
                    break;
                case 4:
                    cetList[0]++;
                    break;
                case 6:
                    cetList[1]++;
                    break;
            }
            cetList[2]++;
        }

        return cetList;
    }
}
