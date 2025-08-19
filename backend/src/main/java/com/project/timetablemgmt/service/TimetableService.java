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

import jakarta.persistence.EntityNotFoundException;

@Service
public class TimetableService {
    
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private TimetableMapper timetableMapper;

    public List<TimetableDTO> getAll() {
        List<Timetable> timetables = timetableRepository.findAll();
        return timetables.stream()
                   .map(timetableMapper::convertEntitytoDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TimetableDTO> getById(Long id) {
        Optional<Timetable> optionalTimetable = timetableRepository.findById(id);
        return optionalTimetable.map(timetableMapper::convertEntitytoDTO);
    }

    public TimetableDTO create(TimetableDTO timetableDTO) throws InvalidAttributeValueException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Timetable timetable;

        try{
            timetable = timetableMapper.convertDTOtoEntity(timetableDTO);
            timetable = timetableRepository.save(timetable);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return timetableMapper.convertEntitytoDTO(timetable);
    }

    public TimetableDTO update(Long id, TimetableDTO timetableDTO) throws InvalidAttributeValueException {
        String msg = validateTimetable(timetableDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Timetable timetable;    
        
        try{
            timetable = timetableMapper.convertDTOtoEntity(timetableDTO);
            timetable.setId(id);

            timetable = timetableRepository.save(timetable);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return timetableMapper.convertEntitytoDTO(timetable);
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
