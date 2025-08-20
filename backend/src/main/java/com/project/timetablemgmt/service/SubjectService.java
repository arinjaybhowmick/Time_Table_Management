package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.SubjectMapper;
import com.project.timetablemgmt.repository.SubjectRepository;

@Service
public class SubjectService extends AbstractService<Long, SubjectDTO, Subject, SubjectRepository, SubjectMapper> {

}
