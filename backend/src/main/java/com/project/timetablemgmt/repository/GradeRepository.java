package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
