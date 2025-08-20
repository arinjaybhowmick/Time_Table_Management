package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.entity.Teaches;
import com.project.timetablemgmt.framework.BaseRepository;

public interface TeachesRepository extends BaseRepository<Long, Teaches> {

    Teaches findByTeacherAndSubject(Teacher teacher, Subject subject);
}
