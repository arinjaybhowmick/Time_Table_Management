package com.project.timetablemgmt.framework;

/**
 * Base validator interface for validating Data Transfer Objects.
 *
 * @param <D> the type of the Data Transfer Object
 */
public interface BaseValidator<D> {

    /** Validates the given DTO. */
    void validate(D dto) throws AbstractException;

}
