package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.framework.BaseRepository;

public interface PeriodRepository extends BaseRepository<Short, Period> {

    Period findByPeriodNumber(String periodNumber);
}
