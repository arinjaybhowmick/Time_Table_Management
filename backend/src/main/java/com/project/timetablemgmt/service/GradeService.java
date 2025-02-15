package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.mapper.GradeMapper;
import com.project.timetablemgmt.repository.GradeRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class GradeService {
    
    @Autowired
    private GradeRepository repository;

    public List<GradeDTO> getAll() {
        List<Grade> grades = repository.findAll();
        return grades.stream()
                   .map(GradeMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<GradeDTO> getById(Long id) {
        Optional<Grade> optionalGrade = repository.findById(id);
        return optionalGrade.map(GradeMapper::toDTO);
    }

    public GradeDTO create(GradeDTO gradeDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateGrade(gradeDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Grade grade = GradeMapper.toEntity(gradeDTO);
        try{
            grade = repository.save(grade);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return GradeMapper.toDTO(grade);
    }

    public GradeDTO update(Long id, GradeDTO gradeDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateGrade(gradeDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Grade grade = GradeMapper.toEntity(gradeDTO);    
        grade.setId(id);
        try{
            grade = repository.save(grade);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return GradeMapper.toDTO(grade);
    }

    public GradeDTO delete(Long id) {
        GradeDTO gradeDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return gradeDTO;
    }

    private String validateGrade(GradeDTO gradeDTO) {
        
        return null;
    }
}
