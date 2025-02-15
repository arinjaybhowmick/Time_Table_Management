package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Room;

public class RoomMapper {
    public static RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setDisplayName(room.getDisplayName());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setGradeDTO(GradeMapper.toDTO(room.getGrade()));
        return roomDTO;
    }

    public static Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setDisplayName(roomDTO.getDisplayName());
        room.setCapacity(roomDTO.getCapacity());
        room.setGrade(GradeMapper.toEntity(roomDTO.getGradeDTO()));
        return room;
    }
}
