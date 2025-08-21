package com.project.timetablemgmt.component.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private String fullName;
    private String shortName;
    private String email;
    private Short minPeriods;
    private Short maxPeriods;
    private Short priority;
}
