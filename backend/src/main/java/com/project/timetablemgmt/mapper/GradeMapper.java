package com.project.timetablemgmt.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.framework.AbstractMapper;
import com.project.timetablemgmt.repository.TeacherRepository;

@Component
public class GradeMapper extends AbstractMapper<GradeDTO, Grade> {

    @Autowired
    private TeacherRepository teacherRepository;

    public GradeMapper() {
        super(GradeDTO.class, Grade.class);
    }

    @Override
    protected void copyFieldsToDTO(Grade grade, GradeDTO gradeDTO) {
        Optional.ofNullable(grade.getTeacher())
                .map(teacher -> teacher.getShortName())
                .ifPresent(gradeDTO::setTeacherShortName);
    }

    @Override
    protected void copyFieldsToEntity(GradeDTO gradeDTO, Grade grade) {
        grade.setTeacher(Optional.ofNullable(gradeDTO.getTeacherShortName())
                .filter(shortName -> !shortName.isBlank())
                .map(teacherRepository::findByShortName)
                .orElse(null));
    }
}
