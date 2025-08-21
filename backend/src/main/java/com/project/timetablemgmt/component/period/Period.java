package com.project.timetablemgmt.component.period;

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
@Table(name = "TT_PERIOD")
public class Period extends BaseEntity<Short> {
    
    @Column(name = "period_number", length = 2, nullable = false, unique = true)
    private String periodNumber;

    @Column(name = "start_time", length = 4, nullable = false, unique = true)
    private String startTime;

    @Column(name = "end_time", length = 4, nullable = false, unique = true)
    private String endTime;

}
