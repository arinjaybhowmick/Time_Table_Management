package com.project.timetablemgmt.framework;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * A generic request wrapper that holds a list of elements of type {@code D}.
 * <p>
 * This class is typically used to encapsulate input data sent from the client
 * to the API endpoints, allowing for standardized request handling.
 * </p>
 * 
 * @param <D> the type of the data payload contained in the request
 */
@Getter
@Setter
public class BaseRequest<D> {

    /**
     * The list of data elements contained in the request body.
     * <p>
     * This field is expected to be populated by the client in requests
     * and its contents will be passed to the service layer.
     * </p>
     */
    private List<D> data;
}
