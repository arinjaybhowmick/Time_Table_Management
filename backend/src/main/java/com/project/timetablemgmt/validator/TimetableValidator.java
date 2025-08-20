package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class TimetableValidator implements BaseValidator<TimetableDTO> {

    public void validate(TimetableDTO dto) throws AbstractException {

    }

}
