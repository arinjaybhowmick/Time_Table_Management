package com.project.timetablemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.timetablemgmt.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByRoomNumber(String roomNumber);
}
