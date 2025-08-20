package com.project.timetablemgmt.framework;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Base repository interface for all entity repositories.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository}
 * to provide standard operations.
 *
 * @param <I> the type of the Entity Identifier
 * @param <E> the type of the Entity
 */
public interface BaseRepository<I extends Number, E extends BaseEntity<I>> extends JpaRepository<E, I> {

}
