package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.entity.Timetable;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.TimetableMapper;
import com.project.timetablemgmt.repository.TimetableRepository;

@Service
public class TimetableService extends AbstractService<Long, TimetableDTO, Timetable, TimetableRepository, TimetableMapper> {

}
