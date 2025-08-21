package com.project.timetablemgmt.component.teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.timetablemgmt.framework.AbstractController;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends AbstractController<Long, TeacherDTO, TeacherService, TeacherValidator> {

}
