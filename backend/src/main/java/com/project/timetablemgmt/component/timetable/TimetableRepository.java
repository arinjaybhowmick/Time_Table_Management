package com.project.timetablemgmt.component.timetable;

import java.util.Optional;

import com.project.timetablemgmt.component.day.Day;
import com.project.timetablemgmt.component.grade.Grade;
import com.project.timetablemgmt.component.period.Period;
import com.project.timetablemgmt.component.room.Room;
import com.project.timetablemgmt.component.teaches.Teaches;
import com.project.timetablemgmt.framework.BaseRepository;

public interface TimetableRepository extends BaseRepository<Long, Timetable> {

    @Override
    default Optional<Timetable> findByEntity(Timetable timetable) {
        return Optional.ofNullable(
                findByDayAndPeriodAndRoomAndGradeAndTeaches(timetable.getDay(), timetable.getPeriod(),
                        timetable.getRoom(), timetable.getGrade(), timetable.getTeaches()));
    }

    Timetable findByDayAndPeriodAndRoomAndGradeAndTeaches(
            Day day, Period period, Room room, Grade grade, Teaches teaches);

}
