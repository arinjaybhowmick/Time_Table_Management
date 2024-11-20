package com.project.timetablemgmt.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDTO {
    private String periodNumber;
    private String startTime;
    private String endTime;
}
