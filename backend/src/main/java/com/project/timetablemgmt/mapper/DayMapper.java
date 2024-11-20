package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.entity.Day;

public class DayMapper {
    public static DayDTO toDTO(Day day) {
        DayDTO dto = new DayDTO();
        dto.setDisplayName(day.getDisplayName());
        dto.setShortName(day.getShortName());
        return dto;
    }

    public static Day toEntity(DayDTO dto) {
        Day day = new Day();
        day.setDisplayName(dto.getDisplayName());
        day.setShortName(dto.getShortName());
        return day;
    }
}
