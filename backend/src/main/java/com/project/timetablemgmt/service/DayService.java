package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.DayDTO;
import com.project.timetablemgmt.entity.Day;
import com.project.timetablemgmt.mapper.DayMapper;
import com.project.timetablemgmt.repository.DayRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class DayService {
    
    @Autowired
    private DayRepository repository;

    public List<DayDTO> getAll() {
        List<Day> days = repository.findAll();
        return days.stream()
                   .map(DayMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<DayDTO> getById(Short id) {
        Optional<Day> optionalDay = repository.findById(id);
        return optionalDay.map(DayMapper::toDTO);
    }

    public DayDTO create(DayDTO daydto) throws InvalidAttributeValueException {
        String msg = validateDay(daydto);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Day day = DayMapper.toEntity(daydto);
        try{
            day = repository.save(day);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return DayMapper.toDTO(day);
    }

    public DayDTO update(Short id, DayDTO daydto) throws InvalidAttributeValueException {
        String msg = validateDay(daydto);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Day day = DayMapper.toEntity(daydto);    
        day.setId(id);
        try{
            day = repository.save(day);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return DayMapper.toDTO(day);
    }

    public DayDTO delete(Short id) {
        DayDTO daydto = getById(id).orElse(null);
        repository.deleteById(id);
        return daydto;
    }

    private String validateDay(DayDTO daydto){
        if (!daydto.getShortName().matches("^(MON|TUE|WED|THU|FRI|SAT|SUN)$")) 
            return "Invalid Day Short Name";
        return null;
    }
}
