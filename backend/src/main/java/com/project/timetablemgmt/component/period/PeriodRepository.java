package com.project.timetablemgmt.component.period;

import com.project.timetablemgmt.framework.BaseRepository;

public interface PeriodRepository extends BaseRepository<Short, Period> {

    Period findByPeriodNumber(String periodNumber);
}
