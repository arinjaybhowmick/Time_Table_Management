package com.project.timetablemgmt.framework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.timetablemgmt.exception.CompositeException;
import com.project.timetablemgmt.exception.NoDataException;

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
     * The list containing the input data.
     */
    private List<D> inputData;

    /**
     * The list containing the output data.
     */
    private List<D> outputData;

    /**
     * The list to hold exceptions during processing.
     */
    private List<AbstractException> exceptions;

    /**
     * Creates a new record from the given request.
     *
     * @param data the DTO representing the new record
     * @return a {@link BaseResponse} containing the created DTO
     *         and HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public BaseResponse<D> create(@RequestBody BaseRequest<D> data) throws AbstractException {
        return process(data, (input) -> {
            validator.validate(input);
            return service.create(input);
        }, HttpStatus.CREATED);
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
    public BaseResponse<D> read(@RequestBody BaseRequest<D> data) throws AbstractException {
        return process(data, (input) -> service.read(input), HttpStatus.OK);
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
    public BaseResponse<D> update(@RequestBody BaseRequest<D> data) throws AbstractException {
        return process(data, (input) -> {
            validator.validate(input);
            return service.update(input);
        }, HttpStatus.OK);
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
    public BaseResponse<D> delete(@RequestBody BaseRequest<D> data) throws AbstractException {
        return process(data, (input) -> service.delete(input), HttpStatus.OK);
    }

    /**
     * A functional interface representing an operation
     * that can be performed on an object of type {@code D}.
     *
     * @param <D> the type of the input and output of the operation
     */
    @FunctionalInterface
    interface ServiceOperation<D> {

        /**
         * Performs an operation on the given input of type {@code D}.
         * 
         * @param d the input object on which the operation is to be performed
         * @return the result of the operation, of type {@code D}
         * @throws AbstractException if an error occurs during the operation
         */
        D operate(D d) throws AbstractException;
    }

    /**
     * Processes a list of records by performing the operation on each record.
     * The records are processed in a loop, and any exceptions thrown during the
     * operation are caught and added to the {@code exceptions} list.
     * 
     * @param <D>            the type of the data to be processed
     * @param data           the request data containing the list of records
     * @param operation      the operation to be applied to each record
     * @param responseStatus the successfull response {@link HttpStatus} code
     * @return a {@link BaseResponse} containing the response data
     * @throws AbstractException if any error occurs
     */
    private BaseResponse<D> process(BaseRequest<D> data, ServiceOperation<D> operation, HttpStatus responseStatus)
            throws AbstractException {

        preProcess(data);

        for (D input : inputData) {
            try {
                D output = operation.operate(input);
                outputData.add(output);
            } catch (AbstractException ex) {
                exceptions.add(ex);
            }
        }

        postProcess();

        if (!exceptions.isEmpty())
            return BaseResponse.partial(HttpStatus.MULTI_STATUS, outputData,
                    new CompositeException(exceptions).getMessage());
        else
            return BaseResponse.success(responseStatus, outputData);
    }

    /**
     * Pre-processes the incoming request.
     *
     * @param data the request data containing the list of records
     * @throws AbstractException
     */
    private void preProcess(BaseRequest<D> data) throws AbstractException {

        if (ObjectUtils.isEmpty(data.getData()))
            throw new NoDataException("Invalid Request provided");

        this.inputData = data.getData();
        this.outputData = new ArrayList<>();
        this.exceptions = new ArrayList<>();
    }

    /**
     * Post-processes the outgoing response.
     *
     * @throws AbstractException
     */
    private void postProcess() throws AbstractException {
        if (outputData.isEmpty()
                && !exceptions.isEmpty())
            throw new CompositeException(exceptions);
    }

}
