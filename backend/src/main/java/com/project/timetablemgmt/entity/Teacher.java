package com.project.timetablemgmt.entity;

import com.project.timetablemgmt.framework.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TT_TEACHER")
public class Teacher extends BaseEntity<Long> {

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "short_name", length = 4, nullable = false, unique = true)
    private String shortName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "min_periods", nullable = false)
    private Short minPeriods;

    @Column(name = "max_periods", nullable = false)
    private Short maxPeriods;

    @Column(name = "priority", nullable = false)
    private Short priority;
    
}
