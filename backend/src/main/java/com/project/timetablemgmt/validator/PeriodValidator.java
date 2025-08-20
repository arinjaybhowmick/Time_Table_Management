package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utils.ValidatorUtils;

@Component
public class PeriodValidator implements BaseValidator<PeriodDTO> {

    public void validate(PeriodDTO dto) throws AbstractException {
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
