package com.project.timetablemgmt.component.teaches;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class TeachesValidator implements BaseValidator<TeachesDTO> {

    @Override
    public void mandatory(TeachesDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getTeacherShortName(), "Mandatory Teacher Short Name");
        ValidatorUtils.validateNotNull(dto.getSubjectCode(), "Mandatory Subject Code");
    }

    @Override
    public void specific(TeachesDTO dto) throws AbstractException {

    }

}
