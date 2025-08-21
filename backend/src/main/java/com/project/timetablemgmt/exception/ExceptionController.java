package com.project.timetablemgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.timetablemgmt.framework.BaseResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ValidationException.class)
    public BaseResponse<String> handleValidationException(ValidationException ex) {
        return BaseResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR, "Validation Exception: " + ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return BaseResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR, "Constraint Violation Exception: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleException(Exception ex) {
        return BaseResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + ex.getMessage());
    }

}
