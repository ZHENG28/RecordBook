package com.example.records.demo.DemoApplication.service;

import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;

	public Map<Integer, Integer> getCet(){
		Map<Integer, Integer> cetList = new HashMap<>();
		List<Student> studentList = studentRepo.findAll();

		cetList.put(4, 0);
		cetList.put(6, 0);
		for(Student stu: studentList) {
			cetList.put(stu.getCet(), cetList.get(stu.getCet()) + 1);
		}

		return cetList;
	}
}
