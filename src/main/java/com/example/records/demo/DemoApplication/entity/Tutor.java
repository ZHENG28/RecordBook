package com.example.records.demo.DemoApplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Setter
@Getter
@Builder
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;
	private String introduction;
	
	@Tolerate
	public Tutor() {
		
	}
	
	//导师-学生
	@Builder.Default
	@OneToMany(mappedBy = "tutor",cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<Student>();
	
	//导师-学习记录
	@Builder.Default
	@OneToMany(mappedBy = "tutor",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	private Set<LearningRecords> learningRecords = new HashSet<LearningRecords>();
	
}
