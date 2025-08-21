package com.project.timetablemgmt.component.day;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.component.utility.ValidatorUtils;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class DayValidator implements BaseValidator<DayDTO> {

    public void validate(DayDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getShortName(),
                "^(MON|TUE|WED|THU|FRI|SAT|SUN)$", "Invalid Day Short Name");
    }

}
