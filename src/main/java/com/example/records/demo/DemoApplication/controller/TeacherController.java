package com.example.records.demo.DemoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.repository.CClassRepository;

@Controller
public class TeacherController {
	@Autowired
	CClassRepository classRepo;
	
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
	//查看班级名单
	@GetMapping("/queryTotalClass")
	public String queryTotalClass(Model model) {
		List<CClass> totalclass = classRepo.findAll();
		model.addAttribute("totalclass", totalclass);
		return "/teacher/totalClass";
		
	}
}
