package com.example.records.demo.DemoApplication.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	private String className;
	
	@Tolerate
	public CClass() {
		
	}
	
	//学生-班级
	@Builder.Default
	@OneToMany(mappedBy = "cclass",cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<Student>();

	//年级-班级
	@ManyToOne(cascade = {CascadeType.DETACH},fetch = FetchType.EAGER)
	@JoinColumn(name = "grade_id",referencedColumnName = "id")
	private Sgrade sgrade;

}
