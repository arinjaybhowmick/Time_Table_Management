package com.project.timetablemgmt.component.period;

import org.springframework.stereotype.Component;

import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class PeriodMapper extends AbstractMapper<PeriodDTO, Period> {

    public PeriodMapper() {
        super(PeriodDTO.class, Period.class);
    }

}
