package com.project.timetablemgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.framework.AbstractController;
import com.project.timetablemgmt.service.TeachesService;
import com.project.timetablemgmt.validator.TeachesValidator;

@RestController
@RequestMapping("/api/teaches")
public class TeachesController extends AbstractController<Long, TeachesDTO, TeachesService, TeachesValidator> {

}
