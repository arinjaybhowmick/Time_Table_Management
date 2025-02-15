package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
