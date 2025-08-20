package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.RoomMapper;
import com.project.timetablemgmt.repository.RoomRepository;

@Service
public class RoomService extends AbstractService<Long, RoomDTO, Room, RoomRepository, RoomMapper> {

}
