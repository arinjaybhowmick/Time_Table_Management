package com.project.timetablemgmt.component.teacher;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class TeacherValidator implements BaseValidator<TeacherDTO> {

    @Override
    public void mandatory(TeacherDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getShortName(), "Mandatory Teacher Short Name");
        ValidatorUtils.validateNotNull(dto.getFullName(), "Mandatory Teacher Full Name");
        ValidatorUtils.validateNotNull(dto.getEmail(), "Mandatory Teacher Email");
        ValidatorUtils.validateNotNull(dto.getMinPeriods(), "Mandatory Teacher Min Periods");
        ValidatorUtils.validateNotNull(dto.getMaxPeriods(), "Mandatory Teacher Max Periods");
        ValidatorUtils.validateNotNull(dto.getPriority(), "Mandatory Teacher Priority");
    }

    @Override
    public void specific(TeacherDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getEmail(),
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*$",
                "Invalid email format");
    }

}
