package com.example.records.demo.DemoApplication.repository;

import com.example.records.demo.DemoApplication.entity.Sgrade;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;

public interface SgradeRepository extends JpaRepository<Sgrade, Long>
{
    List<Sgrade> findAllByOrderByGradeName();

    List<Sgrade> findByGradeName(String grade);
}
