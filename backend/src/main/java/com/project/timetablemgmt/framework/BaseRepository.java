package com.project.timetablemgmt.framework;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface for all entity repositories.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository}
 * to provide standard operations.
 *
 * @param <I> the type of the Entity Identifier
 * @param <E> the type of the Entity
 */
@NoRepositoryBean
public interface BaseRepository<I extends Number, E extends BaseEntity<I>> extends JpaRepository<E, I> {

    /**
     * Defines a method for finding an entity based on the provided object.
     * <p>
     * This method is meant to be implemented by the child interfaces. The
     * implementation will typically involve matching the attributes of
     * the provided entity to retrieve a corresponding entity from the database.
     * </p>
     *
     * @param entity the entity object containing the search criteria.
     * @return an {@link Optional} containing the found entity, or
     *         {@link Optional#empty()} if no matching entity was found.
     */
    Optional<E> findByEntity(E entity);
}
