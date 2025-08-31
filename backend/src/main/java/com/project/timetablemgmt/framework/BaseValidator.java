package com.project.timetablemgmt.framework;

/**
 * Base validator interface for validating Data Transfer Objects.
 *
 * @param <D> the type of the Data Transfer Object
 */
public interface BaseValidator<D> {

    /** Validation */
    default void validate(D dto) throws AbstractException {
        mandatory(dto);
        specific(dto);
    }

    /** Mandatory Validation */
    void mandatory(D dto) throws AbstractException;

    /** Specific Validation */
    void specific(D dto) throws AbstractException;

}
