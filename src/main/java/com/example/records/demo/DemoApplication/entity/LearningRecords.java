package com.example.records.demo.DemoApplication.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Entity
@Getter
@Setter
public class LearningRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date time;
	@NonNull
	private String title;
	private String place;
	private String content;
	private String instructor;
	
	@Tolerate
	public LearningRecords() {
		
	}
	
	//学生-学习记录
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.DETACH},fetch = FetchType.EAGER)
	@JoinTable(
			name = "stu_learning",
			joinColumns = {@JoinColumn(name="records_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="student_id",referencedColumnName = "stu_id")}
			)
	private Set<Student> students = new HashSet<Student>();
	
	//导师-学习记录
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE})
	@JoinColumn(name = "tutor_id",referencedColumnName = "id")
	private Tutor tutor;
}
