package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TimetableDTO;
import com.project.timetablemgmt.entity.Timetable;
import com.project.timetablemgmt.mapper.TimetableMapper;
import com.project.timetablemgmt.repository.TimetableRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class TimetableService {
    
    @Autowired
    private TimetableRepository repository;

    public List<TimetableDTO> getAll() {
        List<Timetable> timetables = repository.findAll();
        return timetables.stream()
                   .map(TimetableMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TimetableDTO> getById(Long id) {
        Optional<Timetable> optionalTimetable = repository.findById(id);
        return optionalTimetable.map(TimetableMapper::toDTO);
    }

    public TimetableDTO create(TimetableDTO timetableDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Timetable timetable = TimetableMapper.toEntity(timetableDTO);
        try{
            timetable = repository.save(timetable);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return TimetableMapper.toDTO(timetable);
    }

    public TimetableDTO update(Long id, TimetableDTO timetableDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Timetable timetable = TimetableMapper.toEntity(timetableDTO);    
        timetable.setId(id);
        try{
            timetable = repository.save(timetable);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return TimetableMapper.toDTO(timetable);
    }

    public TimetableDTO delete(Long id) {
        TimetableDTO timetableDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return timetableDTO;
    }

    private String validateTimetable(TimetableDTO timetableDTO) {
        
        return null;
    }
}
