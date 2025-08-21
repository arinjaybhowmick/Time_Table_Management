package com.project.timetablemgmt.component.subject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController extends AbstractController<Long, SubjectDTO, SubjectService, SubjectValidator> {

}
