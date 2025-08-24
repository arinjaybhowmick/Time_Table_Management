package com.project.timetablemgmt.framework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
     * Retrieves all records.
     *
     * @return a {@link BaseResponse} containing the list of DTOs
     *         and HTTP status 200 (OK)
     */
    @GetMapping
    public BaseResponse<D> read() throws AbstractException {
        List<D> data = service.read();
        return BaseResponse.success(HttpStatus.OK, data);
    }

    /**
     * Retrieves an existing record of the partial request.
     *
     * @param data the DTO containing partial record
     * @return a {@link BaseResponse} containing the DTO
     *         and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the record does not exist
     */
    @GetMapping("/read")
    public BaseResponse<D> read(@RequestBody D data) throws AbstractException {
        D foundData = service.read(data);
        return BaseResponse.success(HttpStatus.OK, List.of(foundData));
    }

    /**
     * Updates an existing record of the provided request.
     *
     * @param data the DTO containing updated record
     * @return a {@link BaseResponse} containing the updated DTO
     *         and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the record does not exist
     */
    @PutMapping("/update")
    public BaseResponse<D> update(@RequestBody D data) throws AbstractException {
        validator.validate(data);
        D updatedData = service.update(data);
        return BaseResponse.success(HttpStatus.OK, List.of(updatedData));
    }

    /**
     * Deletes a record in the provided request.
     *
     * @param data the DTO containing the record to delete
     * @return a {@link BaseResponse} containing the deleted DTO
     *         and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the record does not exist
     */
    @DeleteMapping("/delete")
    public BaseResponse<D> delete(@RequestBody D data) throws AbstractException {
        D deletedData = service.delete(data);
        return BaseResponse.success(HttpStatus.OK, List.of(deletedData));
    }
}
