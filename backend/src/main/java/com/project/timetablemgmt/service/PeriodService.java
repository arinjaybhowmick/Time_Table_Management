package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.PeriodDTO;
import com.project.timetablemgmt.entity.Period;
import com.project.timetablemgmt.mapper.PeriodMapper;
import com.project.timetablemgmt.repository.PeriodRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class PeriodService {
    
    @Autowired
    private PeriodRepository repository;

    @Autowired
    private PeriodMapper periodMapper;

    public List<PeriodDTO> getAll() {
        List<Period> periods = repository.findAll();
        return periods.stream()
                   .map(periodMapper::convertEntitytoDTO)
                   .collect(Collectors.toList());
    }

    public Optional<PeriodDTO> getById(Short id) {
        Optional<Period> optionalPeriod = repository.findById(id);
        return optionalPeriod.map(periodMapper::convertEntitytoDTO);
    }

    public PeriodDTO create(PeriodDTO perioddto) throws InvalidAttributeValueException {
        String msg = validatePeriod(perioddto);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Period period = periodMapper.convertDTOtoEntity(perioddto);
        try{
            period = repository.save(period);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return periodMapper.convertEntitytoDTO(period);
    }

    public PeriodDTO update(Short id, PeriodDTO perioddto) throws InvalidAttributeValueException {
        String msg = validatePeriod(perioddto);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
            
        Period period = periodMapper.convertDTOtoEntity(perioddto);    
        period.setId(id);
        try{
            period = repository.save(period);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return periodMapper.convertEntitytoDTO(period);
    }

    public PeriodDTO delete(Short id) {
        PeriodDTO perioddto = getById(id).orElse(null);
        repository.deleteById(id);
        return perioddto;
    }

    private String validatePeriod(PeriodDTO perioddto){
        if (Integer.parseInt(perioddto.getPeriodNumber()) < 1)
            return "Period number must be at least 1";
        else if (!perioddto.getStartTime().matches("^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$")) 
            return "Start time must be in 24-hour format";
        else if (!perioddto.getEndTime().matches("^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$")) 
            return "End time must be in 24-hour format";
        else if(Integer.parseInt(perioddto.getStartTime()) >= Integer.parseInt(perioddto.getEndTime()))
            return "Start time must be less than End time";
        return null;
    }
}
