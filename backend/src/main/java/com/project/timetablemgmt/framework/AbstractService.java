package com.project.timetablemgmt.framework;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.timetablemgmt.exception.DatabaseException;
import com.project.timetablemgmt.exception.NotFoundException;

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
     * Creates a new entity from the given DTO.
     *
     * @param dto the DTO to create the entity from
     * @return the created DTO after persisting
     */
    public D create(D dto) throws AbstractException {
        E entity = mapper.convertDTOtoEntity(dto);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            throw new DatabaseException(ex.getClass().getSimpleName());
        }
        return mapper.convertEntitytoDTO(entity);
    }

    /**
     * Retrieves all entities.
     *
     * @return a list of DTOs representing all entities
     */
    public List<D> read() throws AbstractException {
        List<E> entity = repository.findAll();
        return entity.stream()
                .map(mapper::convertEntitytoDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves an existing entity from the given DTO.
     *
     * @param dto the DTO containing partial data
     * @return the DTO of the existing entity
     */
    public D read(D dto) throws AbstractException {
        E entity = mapper.convertDTOtoEntity(dto);

        Optional<E> foundEntity = repository.findByEntity(entity);
        foundEntity.orElseThrow(() -> new NotFoundException("Entity not present"));

        entity = foundEntity.get();
        return mapper.convertEntitytoDTO(entity);
    }

    /**
     * Updates an existing entity from the given DTO.
     *
     * @param dto the DTO containing updated data
     * @return the updated DTO
     */
    public D update(D dto) throws AbstractException {
        E entity = mapper.convertDTOtoEntity(dto);

        Optional<E> foundEntity = repository.findByEntity(entity);
        foundEntity.orElseThrow(() -> new NotFoundException("Entity not present"));

        try {
            entity.setId(foundEntity.get().getId());
            entity = repository.save(entity);
        } catch (Exception ex) {
            throw new DatabaseException(ex.getClass().getSimpleName());
        }
        return mapper.convertEntitytoDTO(entity);
    }

    /**
     * Deletes an entity of the given DTO.
     *
     * @param dto the DTO containing data to delete
     * @return the DTO of the deleted entity
     */
    public D delete(D dto) throws AbstractException {
        E entity = mapper.convertDTOtoEntity(dto);

        Optional<E> foundEntity = repository.findByEntity(entity);
        foundEntity.orElseThrow(() -> new NotFoundException("Entity not present"));

        try {
            entity = foundEntity.get();
            repository.deleteById(entity.getId());
        } catch (Exception ex) {
            throw new DatabaseException(ex.getClass().getSimpleName());
        }
        return mapper.convertEntitytoDTO(entity);
    }

}
