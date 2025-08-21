package com.project.timetablemgmt.component.room;

import com.project.timetablemgmt.framework.BaseRepository;

public interface RoomRepository extends BaseRepository<Long, Room> {

    Room findByRoomNumber(String roomNumber);
}
