package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	//查询某个班的CET信息
	@PostMapping("/queryCET46")
	@ResponseBody
	public Map<String, Integer> queryCET46(@RequestBody Map<String,String> queryinfo) {
		String classname = queryinfo.get("classname");
//		Map<Integer, Integer> cetList = studentService.getCet();
//		Map<String, Integer> cetList2 = new HashMap<>();
//		cetList2.put("CET4", cetList.get(4));
//		cetList2.put("CET6", cetList.get(6));
		System.out.println(classname);
		Map<String,Integer> response = new HashMap<>();
		Integer cet4 = 20;
		Integer cet6 = 10;
		Integer total = 40;
		response.put("CET4",cet4);
		response.put("CET6",cet6);
		response.put("total",total);
		return response;
	}

	//查询所有的年纪
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

	//查询一个年纪有哪几个班
	@PostMapping("/getClassByAge")
	@ResponseBody
	public Map<String ,List> getClassByAge(@RequestBody Map<String,String> ages){
		String grade = ages.get("age");
		System.out.println(grade);
		Map<String,List> grades = new HashMap<>();

//		总之返回一个list
		ArrayList<String> list = new ArrayList<>();
//		这里先假装查询到了班级
		list.add("计师19");
		list.add("教技19");
		list.add("机师19");
		list.add("心理19");
		grades.put("data",list);
		return grades;
	}
}
