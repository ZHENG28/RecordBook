package com.example.records.demo.DemoApplication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.*;
import lombok.experimental.Tolerate;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "teacher_id")
@AllArgsConstructor
@Table(name="teacher")
public class Teacher extends CUser{
	
	private String name;
	
	@Tolerate
	public Teacher() {
		
	}
	
	@Builder.Default
	@OneToMany(mappedBy = "teacher",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set<Activity> activities = new HashSet<Activity>();
	
	//继承下重构teacher
	@Builder
	public Teacher(Long id,@NonNull String username,@NonNull String password,
			@NonNull String roles,Boolean active,String name,Set<Activity> activities) {
		super(id,username,password,roles,active);
		this.name = name;
		this.activities = activities;
	}
}
