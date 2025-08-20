package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.TimetableService;
import com.project.timetablemgmt.validator.TimetableValidator;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController extends AbstractController<Long, TimetableDTO, TimetableService, TimetableValidator> {

}
