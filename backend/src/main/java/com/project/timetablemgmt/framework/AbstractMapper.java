package com.project.timetablemgmt.framework;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for mapping between DTO and Entity objects.
 *
 * @param <D> the type of the Data Transfer Object
 * @param <E> the type of the Entity
 */
public abstract class AbstractMapper<D, E> {

    /**
     * The class object for the DTO type.
     */
    private final Class<D> dtoClass;

    /**
     * The class object for the Entity type.
     */
    private final Class<E> entityClass;

    /**
     * Constructs an AbstractMapper with the given DTO and Entity classes.
     *
     * @param dtoClass the DTO class object
     * @param entityClass the Entity class object
     */
    public AbstractMapper(Class<D> dtoClass, Class<E> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    /**
     * Converts a DTO object to its corresponding Entity instance.
     *
     * @param dto the Data Transfer Object to convert
     * @return a new entity instance with fields populated from the DTO
     * @throws RuntimeException if instantiation or field copying fails
     */
    public E convertDTOtoEntity(D dto) {
        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            copyFieldsImplicitly(dto, entity);
            copyFieldsToEntity(dto, entity);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert DTO to Entity", e);
        }
    }

    /**
     * Converts an Entity object to its corresponding DTO instance.
     *
     * @param entity the entity object to convert
     * @return a new DTO instance with fields populated from the entity
     * @throws RuntimeException if instantiation or field copying fails
     */
    public D convertEntitytoDTO(E entity) {
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            copyFieldsImplicitly(entity, dto);
            copyFieldsToDTO(entity, dto);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Entity to DTO", e);
        }
    }

    /**
     * Copies fields with matching names and types from a source object to a target
     * object using reflection.
     * <p>
     * Only fields that exist in both the source and target objects and have the
     * same name and type will be copied. Private fields are also included by
     * setting accessibility to true.
     * <p>
     *
     * @param source the source object to copy fields from
     * @param target the target object to copy fields to 
     * @throws IllegalAccessException  
     * @throws IllegalArgumentException 
     */
    private void copyFieldsImplicitly(Object source, Object target) throws IllegalAccessException {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Objects must not be null");
        }

        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Map<String, Field> targetFieldMap = new HashMap<>();
        for (Field targetField : targetClass.getDeclaredFields()) {
            targetField.setAccessible(true);
            targetFieldMap.put(targetField.getName(), targetField);
        }

        for (Field sourceField : sourceClass.getDeclaredFields()) {
            sourceField.setAccessible(true);
            Field targetField = targetFieldMap.get(sourceField.getName());

            if (targetField != null && targetField.getType().equals(sourceField.getType())) {
                Object value = sourceField.get(source);
                targetField.set(target, value);
            }
        }
    }

    /**
     * Copies specific fields from the entity to the DTO.
     * This method should be overridden to map entity fields into the DTO.
     *
     * @param entity the entity object to copy data from
     * @param dto    the DTO object to copy data to
     */
    protected void copyFieldsToDTO(E entity, D dto) {
        // Override in subclass to map fields explicitly from entity to DTO
    }

    /**
     * Copies specific fields from the DTO to the entity.
     * This method should be overridden to map DTO fields into the entity.
     *
     * @param dto    the DTO object to copy data from
     * @param entity the entity object to copy data to
     */
    protected void copyFieldsToEntity(D dto, E entity) {
        // Override in subclass to map fields explicitly from DTO to entity
    }
}
