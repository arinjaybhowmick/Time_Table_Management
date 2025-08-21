package com.project.timetablemgmt.component.subject;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class SubjectMapper extends AbstractMapper<SubjectDTO, Subject> {

    public SubjectMapper() {
        super(SubjectDTO.class, Subject.class);
    }

}
