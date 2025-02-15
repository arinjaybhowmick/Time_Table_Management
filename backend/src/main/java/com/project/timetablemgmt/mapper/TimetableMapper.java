package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.entity.Timetable;

public class TimetableMapper {
    public static TimetableDTO toDTO(Timetable timetable) {
        TimetableDTO timetableDTO = new TimetableDTO();
        timetableDTO.setDayDTO(DayMapper.toDTO(timetable.getDay()));
        timetableDTO.setPeriodDTO(PeriodMapper.toDTO(timetable.getPeriod()));
        timetableDTO.setRoomDTO(RoomMapper.toDTO(timetable.getRoom()));
        timetableDTO.setGradeDTO(GradeMapper.toDTO(timetable.getGrade()));
        timetableDTO.setTeacherDTO(TeacherMapper.toDTO(timetable.getTeacher()));
        return timetableDTO;
    }

    public static Timetable toEntity(TimetableDTO timetableDTO) {
        Timetable timetable = new Timetable();
        timetable.setDay(DayMapper.toEntity(timetableDTO.getDayDTO()));
        timetable.setPeriod(PeriodMapper.toEntity(timetableDTO.getPeriodDTO()));
        timetable.setRoom(RoomMapper.toEntity(timetableDTO.getRoomDTO()));
        timetable.setGrade(GradeMapper.toEntity(timetableDTO.getGradeDTO()));
        timetable.setTeacher(TeacherMapper.toEntity(timetableDTO.getTeacherDTO()));
        return timetable;
    }
}
