package com.project.timetablemgmt.component.timetable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableDTO {
    private String dayShortName;
    private String periodNumber;
    private String roomNumber;
    private String className;
    private String teacherShortName;
    private String subjectCode;
}
