package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.InvalidAttributeValueException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.mapper.TeacherMapper;
import com.project.timetablemgmt.repository.TeacherRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository repository;

    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherDTO> getAll() {
        List<Teacher> teachers = repository.findAll();
        return teachers.stream()
                   .map(teacherMapper::convertEntitytoDTO)
                   .collect(Collectors.toList());
    }

    public Optional<TeacherDTO> getById(Long id) {
        Optional<Teacher> optionalTeacher = repository.findById(id);
        return optionalTeacher.map(teacherMapper::convertEntitytoDTO);
    }

    public TeacherDTO create(TeacherDTO teacherDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTeacher(teacherDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);

        Teacher teacher = teacherMapper.convertDTOtoEntity(teacherDTO);
        try{
            teacher = repository.save(teacher);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return teacherMapper.convertEntitytoDTO(teacher);
    }

    public TeacherDTO update(Long id, TeacherDTO teacherDTO) throws InvalidAttributeValueException, ConstraintViolationException {
        String msg = validateTeacher(teacherDTO);
        if (msg != null) 
            throw new InvalidAttributeValueException(msg);
        
        Teacher teacher = teacherMapper.convertDTOtoEntity(teacherDTO);    
        teacher.setId(id);
        try{
            teacher = repository.save(teacher);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return teacherMapper.convertEntitytoDTO(teacher);
    }

    public TeacherDTO delete(Long id) {
        TeacherDTO teacherDTO = getById(id).orElse(null);
        repository.deleteById(id);
        return teacherDTO;
    }

    private String validateTeacher(TeacherDTO teacherDTO) {
        if (!teacherDTO.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*$"))
            return "Invalid email format";
        return null;
    }
}
