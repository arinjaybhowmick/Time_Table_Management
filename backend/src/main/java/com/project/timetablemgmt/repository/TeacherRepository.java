package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Teacher;
import com.project.timetablemgmt.framework.BaseRepository;

public interface TeacherRepository extends BaseRepository<Long, Teacher> {

    Teacher findByShortName(String shortName);
}
