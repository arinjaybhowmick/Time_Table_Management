package com.project.timetablemgmt.framework;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * A generic wrapper for HTTP responses that extends {@link ResponseEntity}.
 * <p>
 * This class encapsulates a standardized response format
 * including status code, data payload, and error message.
 * </p>
 *
 * @param <T> the type of data returned in the response body
 */
public class BaseResponse<T> extends ResponseEntity<ResponseTemplate<T>> {

    /**
     * Constructs a new {@code BaseResponse} with the given status, data, and error
     * message.
     *
     * @param status the HTTP status to set in the response
     * @param data   the list of data items to return in the response
     * @param error  the error message to return
     */
    private BaseResponse(HttpStatus status, List<T> data, String error) {
        super(new ResponseTemplate<T>(status.value(), data, error), status);
    }

    /**
     * Creates a successful response with the given status and data.
     *
     * @param status the HTTP status code
     * @param data   the list of data items
     * @param <T>    the type of the data
     * @return a {@code BaseResponse} representing a successful result
     */
    public static <T> BaseResponse<T> success(HttpStatus status, List<T> data) {
        return new BaseResponse<>(status, data != null ? data : Collections.emptyList(), null);
    }

    /**
     * Creates a failure response with the given status and error message.
     *
     * @param status the HTTP status code
     * @param error  the error message
     * @param <T>    the type of the data
     * @return a {@code BaseResponse} representing an error result
     */
    public static <T> BaseResponse<T> failure(HttpStatus status, String error) {
        return new BaseResponse<>(status, Collections.emptyList(), error);
    }

    /**
     * Creates a partial success response with
     * the given status, data, and error messages.
     *
     * @param status the HTTP status code
     * @param data   the list of data items
     * @param <T>    the type of the data
     * @param error  the error message
     * @return a {@code BaseResponse} representing a partial success result
     */
    public static <T> BaseResponse<T> partial(HttpStatus status, List<T> data, String error) {
        return new BaseResponse<>(status, data != null ? data : Collections.emptyList(), error);
    }

}

/**
 * A template class used internally by {@link BaseResponse}
 * to structure the response body.
 *
 * @param <T> the type of the data in the response
 */
@Getter
@Setter
@AllArgsConstructor
class ResponseTemplate<T> {

    /**
     * The numeric HTTP status code.
     */
    private Integer status;

    /**
     * The list of data items.
     */
    private List<T> data;

    /**
     * The error message (if any).
     */
    private String error;

}