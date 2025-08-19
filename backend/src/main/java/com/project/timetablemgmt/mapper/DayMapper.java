package com.project.timetablemgmt.mapper;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class DayMapper extends AbstractMapper<DayDTO, Day> {

    public DayMapper() {
        super(DayDTO.class, Day.class);
    }

}
