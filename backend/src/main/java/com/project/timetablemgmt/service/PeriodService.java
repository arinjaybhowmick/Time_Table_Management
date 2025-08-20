package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public PeriodDTO create(PeriodDTO perioddto) {        
        Period period = periodMapper.convertDTOtoEntity(perioddto);
        try{
            period = repository.save(period);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return periodMapper.convertEntitytoDTO(period);
    }

    public PeriodDTO update(Short id, PeriodDTO perioddto) {            
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
}
