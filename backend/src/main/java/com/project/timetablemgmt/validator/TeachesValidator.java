package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class TeachesValidator implements BaseValidator<TeachesDTO> {

    public void validate(TeachesDTO dto) throws AbstractException {

    }

}
