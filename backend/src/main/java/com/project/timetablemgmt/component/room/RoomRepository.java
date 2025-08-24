package com.project.timetablemgmt.component.room;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface RoomRepository extends BaseRepository<Long, Room> {

    @Override
    default Optional<Room> findByEntity(Room room) {
        return Optional.ofNullable(findByRoomNumber(room.getRoomNumber()));
    }

    Room findByRoomNumber(String roomNumber);
}
