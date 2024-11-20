package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Period;

public interface PeriodRepository extends JpaRepository<Period, Short> {
    
}
