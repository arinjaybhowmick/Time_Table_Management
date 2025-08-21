package com.project.timetablemgmt.component.grade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/grade")
public class GradeController extends AbstractController<Long, GradeDTO, GradeService, GradeValidator> {

}
