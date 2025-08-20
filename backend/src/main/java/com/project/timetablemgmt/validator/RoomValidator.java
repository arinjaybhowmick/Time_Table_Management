package com.project.timetablemgmt.validator;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;

@Component
public class RoomValidator implements BaseValidator<RoomDTO> {

    public void validate(RoomDTO dto) throws AbstractException {

    }
}
