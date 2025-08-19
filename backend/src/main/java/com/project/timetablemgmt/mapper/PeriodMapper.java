package com.project.timetablemgmt.mapper;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class PeriodMapper extends AbstractMapper<PeriodDTO, Period> {

    public PeriodMapper() {
        super(PeriodDTO.class, Period.class);
    }

}
