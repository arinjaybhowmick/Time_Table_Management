package com.project.timetablemgmt.component.period;

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
