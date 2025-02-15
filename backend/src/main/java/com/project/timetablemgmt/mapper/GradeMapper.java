package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;

public class GradeMapper {
    public static GradeDTO toDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setStandard(grade.getStandard());
        gradeDTO.setSection(grade.getSection());
        gradeDTO.setStrength(grade.getStrength());
        gradeDTO.setTeacherDTO(TeacherMapper.toDTO(grade.getTeacher()));
        return gradeDTO;
    }

    public static Grade toEntity(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setStandard(gradeDTO.getStandard());
        grade.setSection(gradeDTO.getSection());
        grade.setStrength(gradeDTO.getStrength());
        grade.setTeacher(TeacherMapper.toEntity(gradeDTO.getTeacherDTO()));
        return grade;
    }
}
