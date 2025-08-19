package com.project.timetablemgmt.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.framework.AbstractMapper;
import com.project.timetablemgmt.repository.GradeRepository;

@Component
public class RoomMapper extends AbstractMapper<RoomDTO, Room> {

    @Autowired
    private GradeRepository gradeRepository;

    public RoomMapper() {
        super(RoomDTO.class, Room.class);
    }

    @Override
    protected void copyFieldsToDTO(Room room, RoomDTO roomDTO) {
        Optional.ofNullable(room.getGrade())
                .map(grade -> grade.getClassName())
                .ifPresent(roomDTO::setClassName);
    }

    @Override
    protected void copyFieldsToEntity(RoomDTO roomDTO, Room room) {
        room.setGrade(Optional.ofNullable(roomDTO.getClassName())
                .filter(className -> !className.isBlank())
                .map(gradeRepository::findByClassName)
                .orElse(null));
    }
}
