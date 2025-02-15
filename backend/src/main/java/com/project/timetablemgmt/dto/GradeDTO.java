package com.project.timetablemgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private String standard;
    private String section;
    private Short strength;
    private TeacherDTO teacherDTO;
}
