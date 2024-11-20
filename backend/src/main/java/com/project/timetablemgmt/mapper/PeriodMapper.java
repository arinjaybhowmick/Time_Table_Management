package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.entity.Period;

public class PeriodMapper {
    public static PeriodDTO toDTO(Period period) {
        PeriodDTO dto = new PeriodDTO();
        dto.setPeriodNumber(period.getPeriodNumber());
        dto.setStartTime(period.getStartTime());
        dto.setEndTime(period.getEndTime());
        return dto;
    }

    public static Period toEntity(PeriodDTO dto) {
        Period period = new Period();
        period.setPeriodNumber(dto.getPeriodNumber());
        period.setStartTime(dto.getStartTime());
        period.setEndTime(dto.getEndTime());
        return period;
    }
}
