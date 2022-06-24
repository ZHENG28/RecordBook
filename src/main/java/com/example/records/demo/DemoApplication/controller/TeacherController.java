package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.entity.Achievement;
import com.example.records.demo.DemoApplication.entity.CClass;
import com.example.records.demo.DemoApplication.entity.Project;
import com.example.records.demo.DemoApplication.entity.Student;
import com.example.records.demo.DemoApplication.repository.CClassRepository;
import com.example.records.demo.DemoApplication.repository.StudentRepository;
import com.example.records.demo.DemoApplication.service.StudentService;
import com.example.records.demo.DemoApplication.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class TeacherController
{
    @Autowired
    CClassRepository classRepo;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    //dark
    //teacher主页
    @GetMapping("/teacherIndex_dark")
    public String teacherIndex_dark()
    {
        return "teacher/teacherIndex";
    }

    //进入亮模式
    @GetMapping("/toLight")
    public String toLight()
    {
        return "teacher/layout-sidenav-light";
    }


    //light
    //进入暗模式
    @GetMapping("/toDark")
    public String toDark()
    {
        return "/teacher/layout-static";
    }


    //查询功能
    //查看所有班级
    @GetMapping("/queryTotalClass")
    @ResponseBody
    public Object queryTotalClass()
    {
        Map<String, Object> totalclass = new HashMap<>();
        List<String> classname = new ArrayList<>();
        for (CClass classes : classRepo.findAll()) {
            classname.add(classes.getClassName());
        }
        totalclass.put("data", classname);
        return totalclass;
    }

    //查看班级学生
    @PostMapping("/queryClassStudent")
    @ResponseBody
    public List<Map<String, Object>> queryClass(@RequestBody Map<String, String> queryinfo)
    {
        List<Map<String, Object>> response = new ArrayList<>();
        String className = queryinfo.get("className");
        List<Student> students = new ArrayList<>();
        Optional<CClass> cClass = classRepo.findByClassName(className);
        students.addAll(cClass.get().getStudents());
        for (Student s : students){
            Map<String, Object> res = new HashMap<>();
            res.put("sgrade",s.getCclass().getSgrade().getGradeName());
            res.put("sclass",s.getCclass().getClassName());
            res.put("snumber",s.getSnumber());
            res.put("sname",s.getName());
            res.put("sid",s.getId());
            response.add(res);
        }
        return response;
    }

    //查看学生电子简历
    @GetMapping("/seeStudentInformation")
    public String getSeeStudentInformation(){
        return "student/views/studentInformation";}
    @PostMapping("/seeStudentInformation")
    public String postSeeStudentInformation(@RequestParam("studentid") String studentid,HttpSession session){
        session.setAttribute("studentid",studentid);
        return "student/views/studentInformation";
    }
    //获取学生简历信息
    @PostMapping("/queryStudentInfo")
    @ResponseBody
    public Map<String,Object> QueryStudentInfo(HttpSession session){
        Calendar calendar = Calendar.getInstance();
        Long studentid = Long.parseLong(session.getAttribute("studentid").toString());
        Student student = studentService.findStuById(studentid);
        Map<String,Object> response = new HashMap<>();
        response.put("name",student.getName());
        response.put("sex",student.getSex());
        response.put("age",String.valueOf(calendar.get(Calendar.YEAR)-Integer.valueOf(student.getBornyear())));
        response.put("sgrade",student.getCclass().getSgrade().getGradeName());
        response.put("sclass",student.getCclass().getClassName());
        response.put("nativePlace",student.getNativePlace());
        response.put("tutor",student.getTutor().getName());
        response.put("phoneNumber",student.getPhoneNumber());
        response.put("email",student.getEmail());
        if(student.getCet() == 4){
            response.put("cet4","通过");
            response.put("cet6","未通过");
        }else if(student.getCet() == 6){
            response.put("cet4","通过");
            response.put("cet6","通过");
        }else{
            response.put("cet4","未通过");
            response.put("cet6","未通过");
        }
        response.put("introduction",student.getIntroduction());
        //存储project信息
        List<Map<String,String>> projects = new ArrayList<>();
        Set<Project> allProjects = student.getProjects();
        for(Project project : allProjects){
            Map<String,String> temp = new HashMap<>();
            temp.put("id",project.getId().toString());
            temp.put("name",project.getName());
            temp.put("ranking",project.getRanking());
            temp.put("time",project.getTime());
            projects.add(temp);
        }
        //存储achivement信息
        List<Map<String,String>> achievements = new ArrayList<>();
        Set<Achievement> allachievements = student.getAchievements();
        for(Achievement achievement : allachievements){
            Map<String,String> temp = new HashMap<>();
            temp.put("id",achievement.getId().toString());
            temp.put("name",achievement.getName());
            temp.put("ranking",achievement.getRanking());
            temp.put("introduction",achievement.getIntroduction());
            temp.put("semester",achievement.getSemesters());
            achievements.add(temp);
        }
        response.put("projects",projects);
        response.put("achievements",achievements);
        return response;
    }

    //查询某个班的CET信息
    @PostMapping("/queryCET46")
    @ResponseBody
    public Map<String, Integer> queryCET46(@RequestBody Map<String, String> queryinfo)
    {
        String grade = queryinfo.get("grade");
        String classname = queryinfo.get("classname");
        Map<String, Integer> response = new HashMap<>();
        int[] cetList = teacherService.getCet(grade, classname);
        response.put("CET4", cetList[0]);
        response.put("CET6", cetList[1]);
        response.put("total", cetList[2]);
        return response;
    }
}
