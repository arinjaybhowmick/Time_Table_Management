package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.utils.ValidatorUtils;

@Component
public class DayValidator {

    public void validate(DayDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getShortName(),
                "^(MON|TUE|WED|THU|FRI|SAT|SUN)$", "Invalid Day Short Name");
    }

}
