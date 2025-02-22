package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.entity.Room;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.entity.Timetable;
import com.project.timetablemgmt.mapper.TimetableMapper;
import com.project.timetablemgmt.repository.DayRepository;
import com.project.timetablemgmt.repository.GradeRepository;
import com.project.timetablemgmt.repository.PeriodRepository;
import com.project.timetablemgmt.repository.RoomRepository;
import com.project.timetablemgmt.repository.SubjectRepository;
import com.project.timetablemgmt.repository.TeacherRepository;
import com.project.timetablemgmt.repository.TeachesRepository;
import com.project.timetablemgmt.repository.TimetableRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TimetableService {
    
    @Autowired
    private TimetableRepository timetableRepository;

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

    public List<TimetableDTO> getAll() {
        List<Timetable> timetables = timetableRepository.findAll();
        return timetables.stream()
                   .map(TimetableMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TimetableDTO> getById(Long id) {
        Optional<Timetable> optionalTimetable = timetableRepository.findById(id);
        return optionalTimetable.map(TimetableMapper::toDTO);
    }

    public TimetableDTO create(TimetableDTO timetableDTO) throws InvalidAttributeValueException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Timetable timetable;

        try{

            Day day = dayRepository.findByShortName(timetableDTO.getDayShortName());
            Period period = periodRepository.findByPeriodNumber(timetableDTO.getPeriodNumber());
            
            Room room = (!timetableDTO.getRoomNumber().isEmpty()) ? 
                                roomRepository.findByRoomNumber(timetableDTO.getRoomNumber()) : null;

            Grade grade = (!timetableDTO.getClassName().isEmpty()) ? 
                                gradeRepository.findByClassName(timetableDTO.getClassName()) : null;

            Teaches teaches = (!timetableDTO.getTeacherShortName().isEmpty() && !timetableDTO.getSubjectCode().isEmpty()) ? 
                                teachesRepository.findByTeacherAndSubject(
                                    teacherRepository.findByShortName(timetableDTO.getTeacherShortName()),
                                    subjectRepository.findByCode(timetableDTO.getSubjectCode())
                                ) : null;

            timetable = TimetableMapper.toEntity(day, period, room, grade, teaches);
            timetable = timetableRepository.save(timetable);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return TimetableMapper.toDTO(timetable);
    }

    public TimetableDTO update(Long id, TimetableDTO timetableDTO) throws InvalidAttributeValueException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Timetable timetable;    
        
        try{
            Day day = dayRepository.findByShortName(timetableDTO.getDayShortName());
            Period period = periodRepository.findByPeriodNumber(timetableDTO.getPeriodNumber());
            
            Room room = (!timetableDTO.getRoomNumber().isEmpty()) ? 
                                roomRepository.findByRoomNumber(timetableDTO.getRoomNumber()) : null;

            Grade grade = (!timetableDTO.getClassName().isEmpty()) ? 
                                gradeRepository.findByClassName(timetableDTO.getClassName()) : null;

            Teaches teaches = (!timetableDTO.getTeacherShortName().isEmpty() && !timetableDTO.getSubjectCode().isEmpty()) ? 
                                teachesRepository.findByTeacherAndSubject(
                                    teacherRepository.findByShortName(timetableDTO.getTeacherShortName()),
                                    subjectRepository.findByCode(timetableDTO.getSubjectCode())
                                ) : null;

            timetable = TimetableMapper.toEntity(day, period, room, grade, teaches);
            timetable.setId(id);

            timetable = timetableRepository.save(timetable);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return TimetableMapper.toDTO(timetable);
    }

    public TimetableDTO delete(Long id) {
        TimetableDTO timetableDTO = getById(id).orElse(null);
        timetableRepository.deleteById(id);
        return timetableDTO;
    }

    private String validateTimetable(TimetableDTO timetableDTO) {
        
        return null;
    }
}
