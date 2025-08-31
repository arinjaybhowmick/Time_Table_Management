package com.project.timetablemgmt.component.teacher;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class TeacherValidator implements BaseValidator<TeacherDTO> {

    public void validate(TeacherDTO dto) throws AbstractException {
        ValidatorUtils.validateFieldRegex(dto.getEmail(),
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*$",
                "Invalid email format");
    }

}
