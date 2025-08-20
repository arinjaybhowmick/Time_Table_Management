package com.project.timetablemgmt.service;

import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.framework.AbstractService;
import com.project.timetablemgmt.mapper.PeriodMapper;
import com.project.timetablemgmt.repository.PeriodRepository;

@Service
public class PeriodService extends AbstractService<Short, PeriodDTO, Period, PeriodRepository, PeriodMapper> {

}
