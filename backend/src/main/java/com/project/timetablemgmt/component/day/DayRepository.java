package com.project.timetablemgmt.component.day;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface DayRepository extends BaseRepository<Short, Day> {

    @Override
    default Optional<Day> findByEntity(Day day) {
        return Optional.ofNullable(findByShortName(day.getShortName()));
    }

    Day findByShortName(String shortName);
}
