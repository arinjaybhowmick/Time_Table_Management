package com.project.timetablemgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableDTO {
    private DayDTO dayDTO;
    private PeriodDTO periodDTO;
    private RoomDTO roomDTO;
    private GradeDTO gradeDTO;
    private TeacherDTO teacherDTO;
}
