package com.project.timetablemgmt.framework;

import java.util.List;

/**
 * Base service interface defining standard operations.
 * <p>
 * This interface should be implemented by all service layers.
 *
 * @param <I> the type of the Entity Identifier
 * @param <D> the type of the Data Transfer Object
 */
public interface BaseService<I extends Number, D> {

    /** Creates a new record. */
    D create(D dto) throws AbstractException;

    /** Returns all records. */
    List<D> read() throws AbstractException;

    /** Returns an existing record. */
    D read(D dto) throws AbstractException;

    /** Updates an existing record. */
    D update(D dto) throws AbstractException;

    /** Deletes an existing record. */
    D delete(D dto) throws AbstractException;

}
