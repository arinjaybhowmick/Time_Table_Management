package com.project.timetablemgmt.component.day;

import com.project.timetablemgmt.framework.BaseRepository;

public interface DayRepository extends BaseRepository<Short, Day> {

    Day findByShortName(String shortName);
}
