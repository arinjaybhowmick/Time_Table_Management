package com.project.timetablemgmt.component.teaches;

import com.project.timetablemgmt.component.subject.Subject;
import com.project.timetablemgmt.component.teacher.Teacher;
import com.project.timetablemgmt.framework.BaseRepository;

public interface TeachesRepository extends BaseRepository<Long, Teaches> {

    Teaches findByTeacherAndSubject(Teacher teacher, Subject subject);
}
