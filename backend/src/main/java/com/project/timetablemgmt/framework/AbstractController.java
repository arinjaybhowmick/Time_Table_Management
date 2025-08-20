package com.project.timetablemgmt.framework;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @return a {@link ResponseEntity} containing the list of DTOs
     *         and HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        List<D> data = service.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    /**
     * Retrieves a single record by its identifier.
     *
     * @param id the identifier of the record
     * @return a {@link ResponseEntity} containing the DTO
     *         and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the record does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable I id) {
        Optional<D> data = service.getById(id);
        return data.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Creates a new record from the given request.
     *
     * @param data the DTO representing the new record
     * @return a {@link ResponseEntity} containing the created DTO
     *         and HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public ResponseEntity<D> create(@RequestBody D data) throws AbstractException {
        validator.validate(data);
        D createdData = service.create(data);
        return new ResponseEntity<>(createdData, HttpStatus.CREATED);
    }

    /**
     * Updates an existing record of the provided request.
     *
     * @param id   the identifier of the record to update
     * @param data the DTO containing updated data
     * @return a {@link ResponseEntity} containing the updated DTO
     *         and HTTP status 200 (OK)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<D> update(@PathVariable I id, @RequestBody D data) throws AbstractException {
        validator.validate(data);
        D updatedData = service.update(id, data);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }

    /**
     * Deletes a record by its identifier.
     *
     * @param id the identifier of the record to delete
     * @return a {@link ResponseEntity} containing the deleted DTO
     *         and HTTP status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<D> delete(@PathVariable I id) {
        D deletedData = service.delete(id);
        return new ResponseEntity<>(deletedData, HttpStatus.OK);
    }
}
