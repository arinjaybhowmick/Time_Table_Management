package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

}
