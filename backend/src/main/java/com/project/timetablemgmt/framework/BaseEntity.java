package com.project.timetablemgmt.framework;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Abstract base class for all entities, providing a generic identifier field.
 * <p>
 * This class is marked as a {@code @MappedSuperclass}, meaning its fields will
 * be mapped to the database columns in subclasses, but it itself will not be
 * treated as a full-fledged entity.
 *
 * @param <I> the type of the Entity Identifier
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity<I extends Number> {

    /**
     * The primary key of the Entity.
     * <p>
     * It is generated using {@link GenerationType#IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;
    
}
