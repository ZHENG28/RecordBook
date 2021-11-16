package com.example.records.demo.DemoApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	//周一
	private int Mon_1;
	private int Mon_2;
	private int Mon_3;
	private int Mon_4;
	private int Mon_5;
	private int Mon_6;
	private int Mon_7;
	private int Mon_8;
	private int Mon_9;
	private int Mon_10;
	private int Mon_11;
	private int Mon_12;
	//周二
	private int Tue_1;
	private int Tue_2;
	private int Tue_3;
	private int Tue_4;
	private int Tue_5;
	private int Tue_6;
	private int Tue_7;
	private int Tue_8;
	private int Tue_9;
	private int Tue_10;
	private int Tue_11;
	private int Tue_12;
	//周三
	private int Wed_1;
	private int Wed_2;
	private int Wed_3;
	private int Wed_4;
	private int Wed_5;
	private int Wed_6;
	private int Wed_7;
	private int Wed_8;
	private int Wed_9;
	private int Wed_10;
	private int Wed_11;
	private int Wed_12;
	//周四
	private int Thu_1;
	private int Thu_2;
	private int Thu_3;
	private int Thu_4;
	private int Thu_5;
	private int Thu_6;
	private int Thu_7;
	private int Thu_8;
	private int Thu_9;
	private int Thu_10;
	private int Thu_11;
	private int Thu_12;
	//周五
	private int Fri_1;
	private int Fri_2;
	private int Fri_3;
	private int Fri_4;
	private int Fri_5;
	private int Fri_6;
	private int Fri_7;
	private int Fri_8;
	private int Fri_9;
	private int Fri_10;
	private int Fri_11;
	private int Fri_12;
	
	@Tolerate
	public Timetable() {
		
	}
}
