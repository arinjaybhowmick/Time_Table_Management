package com.project.timetablemgmt.component.room;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/room")
public class RoomController extends AbstractController<Long, RoomDTO, RoomService, RoomValidator> {

}
