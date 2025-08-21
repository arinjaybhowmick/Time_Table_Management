package com.project.timetablemgmt.component.subject;

import com.project.timetablemgmt.framework.BaseRepository;

public interface SubjectRepository extends BaseRepository<Long, Subject> {

    Subject findByCode(String code);
}
