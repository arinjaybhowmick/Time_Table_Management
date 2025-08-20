package com.project.timetablemgmt.framework;

import java.util.List;
import java.util.Optional;

/**
 * Base service interface defining standard operations.
 * <p>
 * This interface should be implemented by all service layers.
 *
 * @param <I> the type of the Entity Identifier
 * @param <D> the type of the Data Transfer Object
 */
public interface BaseService<I extends Number, D> {

    /** Returns all DTOs. */
    List<D> getAll();

    /** Returns a DTO by its ID. */
    Optional<D> getById(I id);

    /** Creates a new DTO. */
    D create(D dto);

    /** Updates an existing DTO by ID. */
    D update(I id, D dto);

    /** Deletes a DTO by ID. */
    D delete(I id);

}
