package com.project.timetablemgmt.component.room;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractException;
import com.project.timetablemgmt.framework.BaseValidator;
import com.project.timetablemgmt.utility.ValidatorUtils;

@Component
public class RoomValidator implements BaseValidator<RoomDTO> {

    @Override
    public void mandatory(RoomDTO dto) throws AbstractException {
        ValidatorUtils.validateNotNull(dto.getRoomNumber(), "Mandatory Room Number");
        ValidatorUtils.validateNotNull(dto.getDisplayName(), "Mandatory Room Display Name");
        ValidatorUtils.validateNotNull(dto.getCapacity(), "Mandatory Room Capacity");
    }

    @Override
    public void specific(RoomDTO dto) throws AbstractException {

    }

}
