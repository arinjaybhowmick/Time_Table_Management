package com.project.timetablemgmt.component.period;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class PeriodValidator implements BaseValidator<PeriodDTO> {

    @Override
    public void mandatory(PeriodDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getPeriodNumber(), "Mandatory Period Number");
        ValidatorUtils.validateNotNull(dto.getStartTime(), "Mandatory Period Start Time");
        ValidatorUtils.validateNotNull(dto.getEndTime(), "Mandatory Period End Time");
    }

    @Override
    public void specific(PeriodDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getStartTime(),
                "^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$", "Start time must be in 24-hour format");

        ValidatorUtils.validateFieldRegex(dto.getEndTime(),
                "^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$", "End time must be in 24-hour format");

        ValidatorUtils.validateNotLessThan(Integer.parseInt(dto.getPeriodNumber()), 1,
                "Period number must be at least 1");

        ValidatorUtils.validateNotLessThanEqual(Integer.parseInt(dto.getEndTime()),
                Integer.parseInt(dto.getStartTime()), "Start time must be less than End time");

    }

}
