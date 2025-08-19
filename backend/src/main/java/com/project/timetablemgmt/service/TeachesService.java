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

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeachesService {
    
    @Autowired
    private TeachesRepository teachesRepository;

    @Autowired
    private TeachesMapper teachesMapper;
    
    public List<TeachesDTO> getAll() {
        List<Teaches> teaches = teachesRepository.findAll();
        return teaches.stream()
                   .map(teachesMapper::convertEntitytoDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TeachesDTO> getById(Long id) {
        Optional<Teaches> optionalTeaches = teachesRepository.findById(id);
        return optionalTeaches.map(teachesMapper::convertEntitytoDTO);
    }

    public TeachesDTO create(TeachesDTO teachesDTO) throws InvalidAttributeValueException {
        String msg = validateTeaches(teachesDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Teaches teaches;

        try{
            teaches = teachesMapper.convertDTOtoEntity(teachesDTO);
            teaches = teachesRepository.save(teaches);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return teachesMapper.convertEntitytoDTO(teaches);
    }

    public TeachesDTO update(Long id, TeachesDTO teachesDTO) throws InvalidAttributeValueException {
        String msg = validateTeaches(teachesDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Teaches teaches;    

        try{
            teaches = teachesMapper.convertDTOtoEntity(teachesDTO);
            teaches.setId(id);

            teaches = teachesRepository.save(teaches);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return teachesMapper.convertEntitytoDTO(teaches);
    }

    public TeachesDTO delete(Long id) {
        TeachesDTO teachesDTO = getById(id).orElse(null);
        teachesRepository.deleteById(id);
        return teachesDTO;
    }

    private String validateTeaches(TeachesDTO teachesDTO) {
        
        return null;
    }
}
