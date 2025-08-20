package com.project.timetablemgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public TeacherDTO create(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.convertDTOtoEntity(teacherDTO);
        try{
            teacher = repository.save(teacher);
        }
        catch(Exception ex){
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return teacherMapper.convertEntitytoDTO(teacher);
    }

    public TeacherDTO update(Long id, TeacherDTO teacherDTO) {
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
}
