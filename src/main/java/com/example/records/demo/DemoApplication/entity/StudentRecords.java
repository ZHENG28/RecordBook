package com.example.records.demo.DemoApplication.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name="stu_learning")
public class StudentRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="stu_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="records_id")
    private LearningRecords learningRecords;

    @Tolerate
    public StudentRecords(){

    }
}
