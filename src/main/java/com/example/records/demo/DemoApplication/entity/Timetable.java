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
public class Timetable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //周一
    private String Mon;
    private String Tue;
    private String Wed;
    private String Thu;
    private String Fri;
    private String Sat;
    private String Sun;

    @Tolerate
    public Timetable()
    {

    }
}
