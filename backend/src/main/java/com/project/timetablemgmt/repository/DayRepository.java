package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Day;

public interface DayRepository extends JpaRepository<Day, Short> {
    
}
