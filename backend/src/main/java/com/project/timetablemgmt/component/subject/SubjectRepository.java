package com.project.timetablemgmt.component.subject;

import java.util.Optional;

import com.project.timetablemgmt.framework.BaseRepository;

public interface SubjectRepository extends BaseRepository<Long, Subject> {

    @Override
    default Optional<Subject> findByEntity(Subject subject) {
        return Optional.ofNullable(findByCode(subject.getCode()));
    }

    Subject findByCode(String code);
}
