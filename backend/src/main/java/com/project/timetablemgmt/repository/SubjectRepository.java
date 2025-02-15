package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
