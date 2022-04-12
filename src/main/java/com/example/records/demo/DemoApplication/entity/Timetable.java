package com.example.records.demo.DemoApplication.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Getter
@Setter
@Builder
public class Timetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//星期和课程序列
	private String weekday;
	//是否有课序列
	private String classing;

	@OneToOne(cascade = {CascadeType.DETACH},mappedBy = "timetable")
	private Student student;

	@Tolerate
	public Timetable() {
		
	}
}
