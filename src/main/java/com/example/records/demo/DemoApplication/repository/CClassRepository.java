package com.example.records.demo.DemoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.records.demo.DemoApplication.entity.CClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CClassRepository extends JpaRepository<CClass, Long>
{
    List<CClass> findByClassNameLike(String grade);

    Optional<CClass> findByClassName(String classname);

    @Transactional
    @Procedure(procedureName = "count_student")
    //@Query(nativeQuery = true,value = "call records.count_student(:param1)")
    Integer callStoreProcess(@Param("param") String param1);

    @Transactional
    @Query(nativeQuery = true,value="call test_student(:param)")
    List callStoreProcess2(@Param("param") String param1);

}
