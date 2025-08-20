package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.framework.BaseRepository;

public interface RoomRepository extends BaseRepository<Long, Room> {

    Room findByRoomNumber(String roomNumber);
}
