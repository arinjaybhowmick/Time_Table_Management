package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Teacher;

public class GradeMapper {
    public static GradeDTO toDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setClassName(grade.getClassName());
        gradeDTO.setStrength(grade.getStrength());

        if (grade.getTeacher() != null)
            gradeDTO.setTeacherShortName(grade.getTeacher().getShortName());
            
        return gradeDTO;
    }

    public static Grade toEntity(GradeDTO gradeDTO, Teacher teacher) {
        Grade grade = new Grade();
        grade.setClassName(gradeDTO.getClassName());
        grade.setStrength(gradeDTO.getStrength());
        grade.setTeacher(teacher);
        return grade;
    }
}
