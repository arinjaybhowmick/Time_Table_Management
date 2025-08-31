package com.project.timetablemgmt.component.timetable;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class TimetableValidator implements BaseValidator<TimetableDTO> {

    @Override
    public void mandatory(TimetableDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getDayShortName(), "Mandatory Day Short Name");
        ValidatorUtils.validateNotNull(dto.getPeriodNumber(), "Mandatory Period Number");
    }

    @Override
    public void specific(TimetableDTO dto) throws AbstractException {

    }

}
