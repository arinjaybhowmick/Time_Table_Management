package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.entity.Teaches;

public interface TeachesRepository extends JpaRepository<Teaches, Long> {

    Teaches findByTeacherAndSubject(Teacher teacher, Subject subject);
}
