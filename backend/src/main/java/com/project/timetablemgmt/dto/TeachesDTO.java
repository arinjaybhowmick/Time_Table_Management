package com.project.timetablemgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachesDTO {
    private TeacherDTO teacherDTO;
    private SubjectDTO subjectDTO;
}
