package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.GradeDTO;
import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.mapper.GradeMapper;
import com.project.timetablemgmt.repository.GradeRepository;
import com.project.timetablemgmt.repository.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GradeService {
    
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<GradeDTO> getAll() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream()
                   .map(GradeMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<GradeDTO> getById(Long id) {
        Optional<Grade> optionalGrade = gradeRepository.findById(id);
        return optionalGrade.map(GradeMapper::toDTO);
    }

    public GradeDTO create(GradeDTO gradeDTO) throws InvalidAttributeValueException {
        String msg = validateGrade(gradeDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Grade grade;
        
        try{
            
            Teacher teacher = (!gradeDTO.getTeacherShortName().isEmpty()) ? 
                                teacherRepository.findByShortName(gradeDTO.getTeacherShortName()) : null;

            grade = GradeMapper.toEntity(gradeDTO, teacher);
            grade = gradeRepository.save(grade);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return GradeMapper.toDTO(grade);
    }

    public GradeDTO update(Long id, GradeDTO gradeDTO) throws InvalidAttributeValueException {
        String msg = validateGrade(gradeDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Grade grade;    
        
        try{
            Teacher teacher = (!gradeDTO.getTeacherShortName().isEmpty()) ? 
                                teacherRepository.findByShortName(gradeDTO.getTeacherShortName()) : null;

            grade = GradeMapper.toEntity(gradeDTO, teacher);
            grade.setId(id);

            grade = gradeRepository.save(grade);
        }
        catch(Exception ex){
            throw new EntityNotFoundException(ex.getLocalizedMessage());
        }
        return GradeMapper.toDTO(grade);
    }

    public GradeDTO delete(Long id) {
        GradeDTO gradeDTO = getById(id).orElse(null);
        gradeRepository.deleteById(id);
        return gradeDTO;
    }

    private String validateGrade(GradeDTO gradeDTO) {
        
        return null;
    }
}
