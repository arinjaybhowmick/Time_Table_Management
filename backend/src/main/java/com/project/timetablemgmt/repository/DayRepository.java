package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.framework.BaseRepository;

public interface DayRepository extends BaseRepository<Short, Day> {

    Day findByShortName(String shortName);
}
