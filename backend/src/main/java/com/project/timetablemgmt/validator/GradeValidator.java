package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class GradeValidator implements BaseValidator<GradeDTO> {

    public void validate(GradeDTO dto) throws AbstractException {

    }

}
