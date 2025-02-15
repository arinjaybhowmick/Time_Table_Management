package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.SubjectDTO;
import com.project.timetablemgmt.entity.Subject;

public class SubjectMapper {
    public static SubjectDTO toDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setCode(subject.getCode());
        subjectDTO.setName(subject.getName());
        subjectDTO.setOptional(subject.getOptional());
        subjectDTO.setPeriods(subject.getPeriods());
        return subjectDTO;
    }

    public static Subject toEntity(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setCode(subjectDTO.getCode());
        subject.setName(subjectDTO.getName());
        subject.setOptional(subjectDTO.getOptional());
        subject.setPeriods(subjectDTO.getPeriods());
        return subject;
    }
}
