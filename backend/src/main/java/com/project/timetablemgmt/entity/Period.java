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
@Table(name = "TT_PERIOD")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    
    @Column(name = "period_number", length = 2, nullable = false, unique = true)
    private String periodNumber;

    @Column(name = "start_time", length = 4, nullable = false, unique = true)
    private String startTime;

    @Column(name = "end_time", length = 4, nullable = false, unique = true)
    private String endTime;

}
