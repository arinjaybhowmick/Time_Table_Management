package com.project.timetablemgmt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.framework.AbstractMapper;
import com.project.timetablemgmt.repository.SubjectRepository;
import com.project.timetablemgmt.repository.TeacherRepository;

@Component
public class TeachesMapper extends AbstractMapper<TeachesDTO, Teaches> {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public TeachesMapper() {
        super(TeachesDTO.class, Teaches.class);
    }
    
    @Override
    protected void copyFieldsToDTO(Teaches teaches, TeachesDTO teachesDTO) {
        teachesDTO.setTeacherShortName(teaches.getTeacher().getShortName());
        teachesDTO.setSubjectCode(teaches.getSubject().getCode());
    }

    @Override
    protected void copyFieldsToEntity(TeachesDTO teachesDTO, Teaches teaches) {
        teaches.setTeacher(teacherRepository.findByShortName(teachesDTO.getTeacherShortName()));
        teaches.setSubject(subjectRepository.findByCode(teachesDTO.getSubjectCode()));
    }
}
