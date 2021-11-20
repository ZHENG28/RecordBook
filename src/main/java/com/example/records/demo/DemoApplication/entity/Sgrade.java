package com.example.records.demo.DemoApplication.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
public class Sgrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String gradeName;

    @Tolerate
    public Sgrade(){

    }

    //年级-班级
    @Builder.Default
    @OneToMany(mappedBy = "sgrade",cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.EAGER)
    private Set<CClass> classes = new HashSet<>();


}
