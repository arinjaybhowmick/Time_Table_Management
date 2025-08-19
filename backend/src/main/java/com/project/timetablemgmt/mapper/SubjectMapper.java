package com.project.timetablemgmt.mapper;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class SubjectMapper extends AbstractMapper<SubjectDTO, Subject> {

    public SubjectMapper() {
        super(SubjectDTO.class, Subject.class);
    }

}
