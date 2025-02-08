package com.project.timetablemgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TT_TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
