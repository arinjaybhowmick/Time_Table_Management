package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.mapper.TeachesMapper;
import com.project.timetablemgmt.repository.TeachesRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class TeachesService {
    
    @Autowired
    private TeachesRepository repository;

    public List<TeachesDTO> getAll() {
        List<Teaches> teaches = repository.findAll();
        return teaches.stream()
                   .map(TeachesMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TeachesDTO> getById(Long id) {
        Optional<Teaches> optionalTeaches = repository.findById(id);
        return optionalTeaches.map(TeachesMapper::toDTO);
    }

    public TeachesDTO create(TeachesDTO teachesDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTeaches(teachesDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Teaches teaches = TeachesMapper.toEntity(teachesDTO);
        try{
            teaches = repository.save(teaches);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return TeachesMapper.toDTO(teaches);
    }

    public TeachesDTO update(Long id, TeachesDTO teachesDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTeaches(teachesDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Teaches teaches = TeachesMapper.toEntity(teachesDTO);    
        teaches.setId(id);
        try{
            teaches = repository.save(teaches);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return TeachesMapper.toDTO(teaches);
    }

    public TeachesDTO delete(Long id) {
        TeachesDTO teachesDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return teachesDTO;
    }

    private String validateTeaches(TeachesDTO teachesDTO) {
        
        return null;
    }
}
