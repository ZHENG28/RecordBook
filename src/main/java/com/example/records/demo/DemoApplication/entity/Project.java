package com.example.records.demo.DemoApplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ranking;
	@NonNull
	private String name;
	@NonNull
	private String time;

	
	@Tolerate
	public Project() {
		
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "student_id",referencedColumnName = "stu_id")
	private Student student;
}
