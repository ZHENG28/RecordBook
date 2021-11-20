package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TeacherController {
	@Autowired
	CClassRepository classRepo;
	
	@Autowired
	StudentService studentService;

	//dark
	//teacher主页
	@GetMapping("/teacherIndex_dark")
	public String teacherIndex_dark() {
		return "/teacher/teacherIndex";
	}
	//进入亮模式
	@GetMapping("/toLight")
	public String toLight() {
		return "/teacher/layout-sidenav-light";
	}
	
	
	//light
	//进入暗模式
	@GetMapping("/toDark")
	public String toDark() {
		return "/teacher/layout-static";
	}
	
	
	//查询功能
	//查看所有班级
	@GetMapping("/queryTotalClass")
	public String queryTotalClass(Model model) {
		List<CClass> totalclass = classRepo.findAll();
		model.addAttribute("totalclass", totalclass);
		return "teacher/totalClass";
	}
	//查看班级学生
	@GetMapping("/queryClass")
	public String queryClass(Model model, @RequestParam(name ="classId") Long classId){
		Optional<CClass> cClass = classRepo.findById(classId);
		Set<Student> students = cClass.get().getStudents();
		model.addAttribute("class",cClass.get());
		model.addAttribute("students",students);
		return "teacher/classStudent";
	}

	@GetMapping("/queryCet")
	@ResponseBody
	public Object queryCet() {
		Map<Integer, Integer> cetList = studentService.getCet();
		Map<String, Integer> cetList2 = new HashMap<>();
		cetList2.put("CET4", cetList.get(4));
		cetList2.put("CET6", cetList.get(6));

		return cetList2;
	}

	@PostMapping("/getAllGrades")
	@ResponseBody
	public Map<String ,List> getAllGrades(){
		Map<String,List> grades = new HashMap<>();

//		总之返回一个list
		ArrayList<String> list = new ArrayList<>();
//		这里先假装查询到了年级
		list.add("2018");
		list.add("2019");
		list.add("2020");
		list.add("2021");
		grades.put("data",list);
		return grades;
	}
}
