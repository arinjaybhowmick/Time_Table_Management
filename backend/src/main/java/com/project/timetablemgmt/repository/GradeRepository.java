package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Grade;
import com.project.timetablemgmt.framework.BaseRepository;

public interface GradeRepository extends BaseRepository<Long, Grade> {

    Grade findByClassName(String className);
}
