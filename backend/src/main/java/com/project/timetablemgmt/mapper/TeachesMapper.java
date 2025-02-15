package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.entity.Teaches;

public class TeachesMapper {
    public static TeachesDTO toDTO(Teaches teaches) {
        TeachesDTO teachesDTO = new TeachesDTO();
        teachesDTO.setTeacherDTO(TeacherMapper.toDTO(teaches.getTeacher()));
        teachesDTO.setSubjectDTO(SubjectMapper.toDTO(teaches.getSubject()));
        return teachesDTO;
    }

    public static Teaches toEntity(TeachesDTO teachesDTO) {
        Teaches teaches = new Teaches();
        teaches.setTeacher(TeacherMapper.toEntity(teachesDTO.getTeacherDTO()));
        teaches.setSubject(SubjectMapper.toEntity(teachesDTO.getSubjectDTO()));
        return teaches;
    }
}
