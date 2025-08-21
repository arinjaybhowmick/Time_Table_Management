package com.project.timetablemgmt.component.teacher;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class TeacherMapper extends AbstractMapper<TeacherDTO, Teacher> {

    public TeacherMapper() {
        super(TeacherDTO.class, Teacher.class);
    }

}
