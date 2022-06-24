package com.example.records.demo.DemoApplication.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.StudentRepository;


@Controller
@SessionAttributes(value = "username")
public class AppController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@PostMapping("/regist")
	public String regist(@RequestParam(name="username") String username,@RequestParam(name="password") String password) {
		System.out.println(username);
		if(!studentRepo.findByUsername(username).equals(Optional.empty())) {
			return "redirect:login.html";
		}else {
			Student student = Student.builder().username(username).password(new BCryptPasswordEncoder().encode(password))
					.active(true).roles("ROLE_STUDENT").build();
			studentRepo.save(student);
			return "redirect:login.html";
		}
	}
	
	@GetMapping("/")
	public String login() {
		return "redirect:login.html";
	}
	
	//双端首页路由
	@GetMapping("/studentIndex")
	public String studentIndex() {
		return "student/studentIndex";
	}
	
	@GetMapping("/teacherIndex")
	public String teacherIndex() {
		return "teacher/teacherIndex";
	}
	
	
	//表单验证
	@PostMapping("/checkname")
	public void checkregistname(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			if(!studentRepo.findByUsername(username).equals(Optional.empty()))
			{
				response.getWriter().print("1");// have
			}
			else if(username.isEmpty())
			{
				response.getWriter().print("3");
			}
			else
			{
				response.getWriter().print("2");//not have
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/checkregistpassword")
	public void checkregistpassword(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String password = request.getParameter("password");
			if(password.isEmpty()|| password.length()<=3)
			{
				response.getWriter().print("1");// have
			}
			else
			{
				response.getWriter().print("2");//not have
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/checkconfirmpassword")
	public void checkconfirmpassword(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String password = request.getParameter("password");
			String passwordold = request.getParameter("passwordold");
			if(!password.equals(passwordold))
			{
				response.getWriter().print("1");// have
			}
			else
			{
				response.getWriter().print("2");//not have
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
