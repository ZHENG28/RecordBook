package com.example.records.demo.DemoApplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.*;
import lombok.experimental.Tolerate;

@Builder
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(name = "stu_id")
@AllArgsConstructor
@Table(name="student")
public class Student extends CUser{
	
	private String snumber;
	private String name;
	//是否卓越教师班
	private boolean istclass;
	//46级通过情况
	private int cet;
	private String introduction;
	private String nickname;
	//籍贯
	private String nativePlace;
	private String phoneNumber;
	private String email;


	@Tolerate
	public Student() {
		
	}
	
	//学生-活动
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.EAGER)
	@JoinTable(
			name="engage",
			joinColumns = {@JoinColumn(name="stu_id",referencedColumnName = "stu_id")},
			inverseJoinColumns = {@JoinColumn(name="activity_id",referencedColumnName = "id")}
			)
	private Set<Activity> activities = new HashSet<Activity>();
	
	//学生-立项
	@Builder.Default
	@OneToMany(mappedBy = "student",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<Project> projects = new HashSet<Project>();
	
	//学生-课表
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "timetable")
	private Timetable timetable;
	
	//学生-获奖记录
	@Builder.Default
	@OneToMany(mappedBy = "student",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<Achievement> achievements = new HashSet<Achievement>();
	
	//学生-导师
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE})
	@JoinColumn(name = "tutor_id",referencedColumnName = "id")
	private Tutor tutor;
	
	//学生-学习记录
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinTable(
			name = "stu_learning",
			joinColumns = {@JoinColumn(name="stu_id",referencedColumnName = "stu_id")},
			inverseJoinColumns = {@JoinColumn(name="records_id",referencedColumnName = "id")}
			)
	private Set<LearningRecords> learningRecords = new HashSet<LearningRecords>();
	
	//学生-班级
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "class_id",referencedColumnName = "id")
	private CClass cclass;
	
	//继承下重构student
	@Builder
	public Student(Long id,@NonNull String username,@NonNull String password,
			@NonNull String roles,Boolean active,String snumber, String name, boolean istclass, int cet, String introduction,
			String nickname,String nativePlace,String phoneNumber,String email,Set<Activity> activities, Set<Project> projects, Timetable timetable,
			Set<Achievement> achievements, Tutor tutor, Set<LearningRecords> learningRecords) {
		super(id,username,password,roles,active);
		this.snumber = snumber;
		this.name = name;
		this.istclass = istclass;
		this.cet = cet;
		this.introduction = introduction;
		this.nickname = nickname;
		this.activities = activities;
		this.projects = projects;
		this.timetable = timetable;
		this.achievements = achievements;
		this.tutor = tutor;
		this.learningRecords = learningRecords;
		this.nativePlace = nativePlace;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
}
