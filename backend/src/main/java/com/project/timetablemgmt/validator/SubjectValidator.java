package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class SubjectValidator implements BaseValidator<SubjectDTO> {

    public void validate(SubjectDTO dto) throws AbstractException {

    }

}
