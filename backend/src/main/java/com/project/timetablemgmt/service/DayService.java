package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.DayMapper;
import com.project.timetablemgmt.repository.DayRepository;

@Service
public class DayService extends AbstractService<Short, DayDTO, Day, DayRepository, DayMapper> {

}
