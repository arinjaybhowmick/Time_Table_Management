package com.project.timetablemgmt.component.teacher;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface TeacherRepository extends BaseRepository<Long, Teacher> {

    @Override
    default Optional<Teacher> findByEntity(Teacher teacher) {
        return Optional.ofNullable(findByShortName(teacher.getShortName()));
    }

    Teacher findByShortName(String shortName);
}
