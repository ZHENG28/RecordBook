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
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Entity
@Setter
@Getter
public class CClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String class_name;
	
	@Tolerate
	public CClass() {
		
	}
	
	//学生-班级
	@Builder.Default
	@OneToMany(mappedBy = "cclass",cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<Student>();
	
}
