package com.project.timetablemgmt.component.period;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/period")
public class PeriodController extends AbstractController<Short, PeriodDTO, PeriodService, PeriodValidator> {

}
