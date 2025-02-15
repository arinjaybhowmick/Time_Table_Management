package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.mapper.SubjectMapper;
import com.project.timetablemgmt.repository.SubjectRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository repository;

    public List<SubjectDTO> getAll() {
        List<Subject> subjects = repository.findAll();
        return subjects.stream()
                   .map(SubjectMapper::toDTO)
                   .collect(Collectors.toList());
    }

    public Optional<SubjectDTO> getById(Long id) {
        Optional<Subject> optionalSubject = repository.findById(id);
        return optionalSubject.map(SubjectMapper::toDTO);
    }

    public SubjectDTO create(SubjectDTO subjectDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateSubject(subjectDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Subject subject = SubjectMapper.toEntity(subjectDTO);
        try{
            subject = repository.save(subject);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return SubjectMapper.toDTO(subject);
    }

    public SubjectDTO update(Long id, SubjectDTO subjectDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateSubject(subjectDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Subject subject = SubjectMapper.toEntity(subjectDTO);    
        subject.setId(id);
        try{
            subject = repository.save(subject);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return SubjectMapper.toDTO(subject);
    }

    public SubjectDTO delete(Long id) {
        SubjectDTO subjectDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return subjectDTO;
    }

    private String validateSubject(SubjectDTO subjectDTO) {
        
        return null;
    }
}
