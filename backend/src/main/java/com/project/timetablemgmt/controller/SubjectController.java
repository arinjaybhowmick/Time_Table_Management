package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.SubjectService;
import com.project.timetablemgmt.validator.SubjectValidator;

@RestController
@RequestMapping("/api/subject")
public class SubjectController extends AbstractController<Long, SubjectDTO, SubjectService, SubjectValidator> {

}
