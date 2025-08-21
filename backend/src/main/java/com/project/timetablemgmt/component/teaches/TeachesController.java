package com.project.timetablemgmt.component.teaches;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/teaches")
public class TeachesController extends AbstractController<Long, TeachesDTO, TeachesService, TeachesValidator> {

}
