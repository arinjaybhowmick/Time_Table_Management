package com.project.timetablemgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private String className;
    private Short strength;
    private String teacherShortName;
}
