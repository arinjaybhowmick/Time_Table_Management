package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.GradeMapper;
import com.project.timetablemgmt.repository.GradeRepository;

@Service
public class GradeService extends AbstractService<Long, GradeDTO, Grade, GradeRepository, GradeMapper> {

}
