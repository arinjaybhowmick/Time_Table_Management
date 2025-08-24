package com.project.timetablemgmt.component.teaches;

import java.util.Optional;

import com.project.timetablemgmt.component.subject.Subject;
import com.project.timetablemgmt.component.teacher.Teacher;
import com.project.timetablemgmt.framework.BaseRepository;

public interface TeachesRepository extends BaseRepository<Long, Teaches> {

    @Override
    default Optional<Teaches> findByEntity(Teaches teaches) {
        return Optional.ofNullable(findByTeacherAndSubject(teaches.getTeacher(), teaches.getSubject()));
    }

    Teaches findByTeacherAndSubject(Teacher teacher, Subject subject);
}
