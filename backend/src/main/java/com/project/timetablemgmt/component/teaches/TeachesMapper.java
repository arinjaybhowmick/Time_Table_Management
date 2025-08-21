package com.project.timetablemgmt.component.teaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.timetablemgmt.component.subject.SubjectRepository;
import com.project.timetablemgmt.component.teacher.TeacherRepository;
import com.project.timetablemgmt.framework.AbstractMapper;

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
