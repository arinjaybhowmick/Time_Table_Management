package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.RoomDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.RoomService;
import com.project.timetablemgmt.validator.RoomValidator;

@RestController
@RequestMapping("/api/room")
public class RoomController extends AbstractController<Long, RoomDTO, RoomService, RoomValidator> {

}
