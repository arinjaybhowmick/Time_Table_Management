package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.TeachesDTO;
import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.entity.Teaches;

public class TeachesMapper {
    public static TeachesDTO toDTO(Teaches teaches) {
        TeachesDTO teachesDTO = new TeachesDTO();
        teachesDTO.setTeacherShortName(teaches.getTeacher().getShortName());
        teachesDTO.setSubjectCode(teaches.getSubject().getCode());
        return teachesDTO;
    }

    public static Teaches toEntity(Teacher teacher, Subject subject) {
        Teaches teaches = new Teaches();
        teaches.setTeacher(teacher);
        teaches.setSubject(subject);
        return teaches;
    }
}
