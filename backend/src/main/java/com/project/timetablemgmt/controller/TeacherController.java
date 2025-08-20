package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.TeacherService;
import com.project.timetablemgmt.validator.TeacherValidator;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends AbstractController<Long, TeacherDTO, TeacherService, TeacherValidator> {

}
