package com.project.timetablemgmt.component.timetable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.project.timetablemgmt.component.day.DayRepository;
import com.project.timetablemgmt.component.grade.GradeRepository;
import com.project.timetablemgmt.component.period.PeriodRepository;
import com.project.timetablemgmt.component.room.RoomRepository;
import com.project.timetablemgmt.component.subject.SubjectRepository;
import com.project.timetablemgmt.component.teacher.TeacherRepository;
import com.project.timetablemgmt.component.teaches.TeachesRepository;
import com.project.timetablemgmt.framework.AbstractMapper;

@Component
public class TimetableMapper extends AbstractMapper<TimetableDTO, Timetable> {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private TeachesRepository teachesRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public TimetableMapper() {
        super(TimetableDTO.class, Timetable.class);
    }

    @Override
    protected void copyFieldsToDTO(Timetable timetable, TimetableDTO timetableDTO) {
        timetableDTO.setDayShortName(timetable.getDay().getShortName());
        timetableDTO.setPeriodNumber(timetable.getPeriod().getPeriodNumber());

        Optional.ofNullable(timetable.getRoom())
                .map(room -> room.getRoomNumber())
                .ifPresent(timetableDTO::setRoomNumber);

        Optional.ofNullable(timetable.getGrade())
                .map(grade -> grade.getClassName())
                .ifPresent(timetableDTO::setClassName);

        Optional.ofNullable(timetable.getTeaches()).ifPresent(teaches -> {
            Optional.ofNullable(teaches.getTeacher())
                    .map(teacher -> teacher.getShortName())
                    .ifPresent(timetableDTO::setTeacherShortName);

            Optional.ofNullable(teaches.getSubject())
                    .map(subject -> subject.getCode())
                    .ifPresent(timetableDTO::setSubjectCode);
        });
    }

    @Override
    protected void copyFieldsToEntity(TimetableDTO timetableDTO, Timetable timetable) {
        timetable.setDay(Optional.ofNullable(timetableDTO.getDayShortName())
                .filter(day -> !day.isBlank())
                .map(dayRepository::findByShortName)
                .orElse(null));
        
        timetable.setPeriod(Optional.ofNullable(timetableDTO.getPeriodNumber())
                .filter(period -> !period.isBlank())
                .map(periodRepository::findByPeriodNumber)
                .orElse(null));

        timetable.setRoom(Optional.ofNullable(timetableDTO.getRoomNumber())
                .filter(room -> !room.isBlank())
                .map(roomRepository::findByRoomNumber)
                .orElse(null));

        timetable.setGrade(Optional.ofNullable(timetableDTO.getClassName())
                .filter(grade -> !grade.isBlank())
                .map(gradeRepository::findByClassName)
                .orElse(null));

        timetable.setTeaches(Optional.of(timetableDTO)
                        .filter(dto -> !ObjectUtils.isEmpty(dto.getTeacherShortName())
                                        && !ObjectUtils.isEmpty(dto.getSubjectCode()))
                        .filter(dto -> !dto.getTeacherShortName().isBlank() && !dto.getSubjectCode().isBlank())
                        .map(dto -> teachesRepository.findByTeacherAndSubject(
                                        teacherRepository.findByShortName(dto.getTeacherShortName()),
                                        subjectRepository.findByCode(dto.getSubjectCode())))
                        .orElse(null));
}
}
