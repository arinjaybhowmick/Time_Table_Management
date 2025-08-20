package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.TeacherMapper;
import com.project.timetablemgmt.repository.TeacherRepository;

@Service
public class TeacherService extends AbstractService<Long, TeacherDTO, Teacher, TeacherRepository, TeacherMapper> {

}
