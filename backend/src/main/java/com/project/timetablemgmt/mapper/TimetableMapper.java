package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.entity.Timetable;

public class TimetableMapper {
    public static TimetableDTO toDTO(Timetable timetable) {
        TimetableDTO timetableDTO = new TimetableDTO();
        timetableDTO.setDayShortName(timetable.getDay().getShortName());
        timetableDTO.setPeriodNumber(timetable.getPeriod().getPeriodNumber());

        if (timetable.getRoom() != null)
            timetableDTO.setRoomNumber(timetable.getRoom().getRoomNumber());

        if (timetable.getGrade() != null)
            timetableDTO.setClassName(timetable.getGrade().getClassName());

        if (timetable.getTeaches() != null) {
            timetableDTO.setTeacherShortName(timetable.getTeaches().getTeacher().getShortName());
            timetableDTO.setSubjectCode(timetable.getTeaches().getSubject().getCode());
        }
        
        return timetableDTO;
    }

    public static Timetable toEntity(Day day, Period period, Room room, Grade grade, Teaches teaches) {
        Timetable timetable = new Timetable();
        timetable.setDay(day);
        timetable.setPeriod(period);
        timetable.setRoom(room);
        timetable.setGrade(grade);
        timetable.setTeaches(teaches);
        return timetable;
    }
}
