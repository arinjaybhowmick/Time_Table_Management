package com.project.timetablemgmt.component.grade;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class GradeValidator implements BaseValidator<GradeDTO> {

    @Override
    public void mandatory(GradeDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getClassName(), "Mandatory Grade Class Name");
        ValidatorUtils.validateNotNull(dto.getStrength(), "Mandatory Grade Strength");
    }

    @Override
    public void specific(GradeDTO dto) throws AbstractException {

    }

}
