package com.project.timetablemgmt.component.day;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/day")
public class DayController extends AbstractController<Short, DayDTO, DayService, DayValidator> {

}
