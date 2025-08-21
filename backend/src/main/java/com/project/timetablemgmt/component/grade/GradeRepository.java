package com.project.timetablemgmt.component.grade;

import com.project.timetablemgmt.framework.BaseRepository;

public interface GradeRepository extends BaseRepository<Long, Grade> {

    Grade findByClassName(String className);
}
