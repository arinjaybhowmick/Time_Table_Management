package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Room;

public class RoomMapper {
    public static RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setDisplayName(room.getDisplayName());
        roomDTO.setCapacity(room.getCapacity());

        if (room.getGrade() != null)
            roomDTO.setClassName(room.getGrade().getClassName());
            
        return roomDTO;
    }

    public static Room toEntity(RoomDTO roomDTO, Grade grade) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setDisplayName(roomDTO.getDisplayName());
        room.setCapacity(roomDTO.getCapacity());
        room.setGrade(grade);
        return room;
    }
}
