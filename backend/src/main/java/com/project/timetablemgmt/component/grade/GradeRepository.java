package com.project.timetablemgmt.component.grade;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface GradeRepository extends BaseRepository<Long, Grade> {

    @Override
    default Optional<Grade> findByEntity(Grade grade) {
        return Optional.ofNullable(findByClassName(grade.getClassName()));
    }

    Grade findByClassName(String className);
}
