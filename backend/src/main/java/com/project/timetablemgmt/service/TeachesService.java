package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.TeachesMapper;
import com.project.timetablemgmt.repository.TeachesRepository;

@Service
public class TeachesService extends AbstractService<Long, TeachesDTO, Teaches, TeachesRepository, TeachesMapper> {

}
