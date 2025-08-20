package com.project.timetablemgmt.framework;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintViolationException;

/**
 * Abstract base service class providing implementation of {@link BaseService}.
 *
 * @param <I> the type of the Identifier
 * @param <D> the type of the Data Transfer Object
 * @param <E> the type of the Entity
 * @param <R> the type of the Repository
 * @param <M> the type of the Mapper
 */
public abstract class AbstractService<I extends Number, D, E extends BaseEntity<I>, R extends BaseRepository<I, E>, M extends AbstractMapper<D, E>>
        implements BaseService<I, D> {

    /**
     * The object for the Repository.
     */
    @Autowired
    private R repository;

    /**
     * The object for the Mapper.
     */
    @Autowired
    private M mapper;

    /**
     * Retrieves all entities.
     *
     * @return a list of DTOs representing all entities
     */
    public List<D> getAll() {
        List<E> entity = repository.findAll();
        return entity.stream()
                .map(mapper::convertEntitytoDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves an entity by its ID.
     *
     * @param id the identifier of the entity
     * @return an {@link Optional} containing the DTO if found
     */
    public Optional<D> getById(I id) {
        Optional<E> entity = repository.findById(id);
        return entity.map(mapper::convertEntitytoDTO);
    }

    /**
     * Creates a new entity from the given DTO.
     *
     * @param dto the DTO to create the entity from
     * @return the created DTO after persisting
     */
    public D create(D dto) {
        E entity = mapper.convertDTOtoEntity(dto);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            throw new ConstraintViolationException(ex.getLocalizedMessage(), null);
        }
        return mapper.convertEntitytoDTO(entity);
    }

    /**
     * Updates an existing entity with the given ID.
     *
     * @param id  the identifier of the entity to update
     * @param dto the DTO containing updated data
     * @return the updated DTO
     */
    public D update(I id, D dto) {
        E entity = mapper.convertDTOtoEntity(dto);
        entity.setId(id);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            throw new ConstraintViolationException(ex.getMessage(), null);
        }
        return mapper.convertEntitytoDTO(entity);
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the identifier of the entity to delete
     * @return the DTO of the deleted entity
     */
    public D delete(I id) {
        D dto = getById(id).orElse(null);
        repository.deleteById(id);
        return dto;
    }

}
