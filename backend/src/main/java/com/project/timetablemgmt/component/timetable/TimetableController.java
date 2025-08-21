package com.project.timetablemgmt.component.timetable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController extends AbstractController<Long, TimetableDTO, TimetableService, TimetableValidator> {

}
