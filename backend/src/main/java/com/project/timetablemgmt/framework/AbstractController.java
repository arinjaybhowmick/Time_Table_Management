package com.project.timetablemgmt.framework;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Abstract base controller providing basic REST endpoints.
 *
 * @param <I> the type of the Identifier
 * @param <D> the type of the Data Transfer Object
 * @param <S> the type of the Service
 * @param <V> the type of the Validator
 */
public abstract class AbstractController<I extends Number, D, S extends BaseService<I, D>, V extends BaseValidator<D>> {

    /**
     * The object for the Service.
     */
    @Autowired
    private S service;

    /**
     * The object for the Validator.
     */
    @Autowired
    private V validator;

    /**
     * Retrieves all records.
     *
     * @return a {@link BaseResponse} containing the list of DTOs
     *         and HTTP status 200 (OK)
     */
    @GetMapping
    public BaseResponse<D> getAll() {
        List<D> data = service.getAll();
        return BaseResponse.success(HttpStatus.OK, data);
    }

    /**
     * Retrieves a single record by its identifier.
     *
     * @param id the identifier of the record
     * @return a {@link BaseResponse} containing the DTO
     *         and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the record does not exist
     */
    @GetMapping("/{id}")
    public BaseResponse<D> getById(@PathVariable I id) {
        Optional<D> data = service.getById(id);
        return data.map(value -> BaseResponse.success(HttpStatus.OK, List.of(value)))
                .orElseGet(() -> BaseResponse.failure(HttpStatus.NOT_FOUND, "Record Not Found"));
    }

    /**
     * Creates a new record from the given request.
     *
     * @param data the DTO representing the new record
     * @return a {@link BaseResponse} containing the created DTO
     *         and HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public BaseResponse<D> create(@RequestBody D data) throws AbstractException {
        validator.validate(data);
        D createdData = service.create(data);
        return BaseResponse.success(HttpStatus.CREATED, List.of(createdData));
    }

    /**
     * Updates an existing record of the provided request.
     *
     * @param id   the identifier of the record to update
     * @param data the DTO containing updated data
     * @return a {@link BaseResponse} containing the updated DTO
     *         and HTTP status 200 (OK)
     */
    @PutMapping("/update/{id}")
    public BaseResponse<D> update(@PathVariable I id, @RequestBody D data) throws AbstractException {
        validator.validate(data);
        D updatedData = service.update(id, data);
        return BaseResponse.success(HttpStatus.OK, List.of(updatedData));
    }

    /**
     * Deletes a record by its identifier.
     *
     * @param id the identifier of the record to delete
     * @return a {@link BaseResponse} containing the deleted DTO
     *         and HTTP status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public BaseResponse<D> delete(@PathVariable I id) {
        D deletedData = service.delete(id);
        return BaseResponse.success(HttpStatus.OK,
                deletedData != null ? List.of(deletedData) : Collections.emptyList());
    }
}
