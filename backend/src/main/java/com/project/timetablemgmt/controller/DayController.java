package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.DayService;
import com.project.timetablemgmt.validator.DayValidator;

@RestController
@RequestMapping("/api/day")
public class DayController extends AbstractController<Short, DayDTO, DayService, DayValidator> {

}
