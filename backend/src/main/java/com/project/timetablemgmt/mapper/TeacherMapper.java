package com.project.timetablemgmt.mapper;

import com.project.timetablemgmt.dto.TeacherDTO;
import com.project.timetablemgmt.entity.Teacher;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setFullName(teacher.getFullName());
        teacherDTO.setShortName(teacher.getShortName());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setMinPeriods(teacher.getMinPeriods());
        teacherDTO.setMaxPeriods(teacher.getMaxPeriods());
        teacherDTO.setPriority(teacher.getPriority());
        return teacherDTO;
    }

    public static Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setFullName(teacherDTO.getFullName());
        teacher.setShortName(teacherDTO.getShortName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setMinPeriods(teacherDTO.getMinPeriods());
        teacher.setMaxPeriods(teacherDTO.getMaxPeriods());
        teacher.setPriority(teacherDTO.getPriority());
        return teacher;
    }
}
