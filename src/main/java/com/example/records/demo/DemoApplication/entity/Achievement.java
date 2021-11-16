package com.example.records.demo.DemoApplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Entity
@Getter
@Setter
public class Achievement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ranking;
	private String semesters;
	@NotNull
	private String name;
	private String introduction;
	
	@Tolerate
	public Achievement() {
		
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "student_id",referencedColumnName = "stu_id")
	private Student student;
}
