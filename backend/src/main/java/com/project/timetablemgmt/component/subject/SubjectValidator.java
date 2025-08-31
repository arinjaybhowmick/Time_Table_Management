package com.project.timetablemgmt.component.subject;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class SubjectValidator implements BaseValidator<SubjectDTO> {

    @Override
    public void mandatory(SubjectDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getCode(), "Mandatory Subject Code");
        ValidatorUtils.validateNotNull(dto.getName(), "Mandatory Subject Name");
        ValidatorUtils.validateNotNull(dto.getOptional(), "Mandatory Subject Optional");
        ValidatorUtils.validateNotNull(dto.getPeriods(), "Mandatory Subject Periods");
    }

    @Override
    public void specific(SubjectDTO dto) throws AbstractException {

    }

}
