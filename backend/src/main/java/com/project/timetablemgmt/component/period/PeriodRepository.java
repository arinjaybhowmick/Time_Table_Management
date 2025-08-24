package com.project.timetablemgmt.component.period;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface PeriodRepository extends BaseRepository<Short, Period> {

    @Override
    default Optional<Period> findByEntity(Period period) {
        return Optional.ofNullable(findByPeriodNumber(period.getPeriodNumber()));
    }

    Period findByPeriodNumber(String periodNumber);
}
