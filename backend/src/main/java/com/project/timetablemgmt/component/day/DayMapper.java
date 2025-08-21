package com.project.timetablemgmt.component.day;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class DayMapper extends AbstractMapper<DayDTO, Day> {

    public DayMapper() {
        super(DayDTO.class, Day.class);
    }

}
