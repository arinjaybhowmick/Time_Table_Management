package com.project.timetablemgmt.exception;

import com.project.timetablemgmt.framework.AbstractException;

public class NotFoundException extends AbstractException {

    public NotFoundException(String message) {
        super(message);
    }
}
