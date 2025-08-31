package com.project.timetablemgmt.component.day;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class DayValidator implements BaseValidator<DayDTO> {

    @Override
    public void mandatory(DayDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getShortName(), "Mandatory Day Short Name");
        ValidatorUtils.validateNotNull(dto.getDisplayName(), "Mandatory Day Display Name");
    }

    @Override
    public void specific(DayDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getShortName(),
                "^(MON|TUE|WED|THU|FRI|SAT|SUN)$", "Invalid Day Short Name");
    }

}
