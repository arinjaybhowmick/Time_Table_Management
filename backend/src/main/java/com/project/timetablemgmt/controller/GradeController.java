package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.GradeService;
import com.project.timetablemgmt.validator.GradeValidator;

@RestController
@RequestMapping("/api/grade")
public class GradeController extends AbstractController<Long, GradeDTO, GradeService, GradeValidator> {

}
