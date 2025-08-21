package com.project.timetablemgmt.component.teacher;

import com.project.timetablemgmt.framework.BaseRepository;

public interface TeacherRepository extends BaseRepository<Long, Teacher> {

    Teacher findByShortName(String shortName);
}
