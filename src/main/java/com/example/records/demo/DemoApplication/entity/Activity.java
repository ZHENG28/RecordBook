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
@Setter
@Getter
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String organizer;
	private Date time;
	@NonNull
	private String title;
	private String introduction;
	private String lecturer;
	private String place;
	
	@Tolerate
	public Activity() {
		
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "tea_id",referencedColumnName = "teacher_id")
	private Teacher teacher;
	
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
	@JoinTable(
			name="engage",
			joinColumns = {@JoinColumn(name="activity_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name="student_id",referencedColumnName = "stu_id")}
			)
	private Set<Student> students = new HashSet<Student>();
	
}
