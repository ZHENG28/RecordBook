package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//查看班级名单
	@GetMapping("/queryTotalClass")
	public String queryTotalClass(Model model) {
		List<CClass> totalclass = classRepo.findAll();
		model.addAttribute("totalclass", totalclass);
		return "/teacher/totalClass";
		
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
}
