package com.project.timetablemgmt.mapper;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class TeacherMapper extends AbstractMapper<TeacherDTO, Teacher> {

    public TeacherMapper() {
        super(TeacherDTO.class, Teacher.class);
    }

}
