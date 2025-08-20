package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.PeriodService;
import com.project.timetablemgmt.validator.PeriodValidator;

@RestController
@RequestMapping("/api/period")
public class PeriodController extends AbstractController<Short, PeriodDTO, PeriodService, PeriodValidator> {

}
