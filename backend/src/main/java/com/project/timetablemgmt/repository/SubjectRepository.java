package com.project.timetablemgmt.repository;

import com.project.timetablemgmt.entity.Subject;
import com.project.timetablemgmt.framework.BaseRepository;

public interface SubjectRepository extends BaseRepository<Long, Subject> {

    Subject findByCode(String code);
}
