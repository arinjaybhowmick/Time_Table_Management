package com.project.timetablemgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.timetablemgmt.framework.BaseResponse;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ValidationException.class)
    public BaseResponse<String> handleValidationException(ValidationException ex) {
        return BaseResponse.failure(HttpStatus.BAD_REQUEST, "Validation Exception: " + ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public BaseResponse<String> handleNotFoundException(NotFoundException ex) {
        return BaseResponse.failure(HttpStatus.NOT_FOUND, "Record Not Found: " + ex.getMessage());
    }

    @ExceptionHandler(DatabaseException.class)
    public BaseResponse<String> handleDatabaseException(DatabaseException ex) {
        return BaseResponse.failure(HttpStatus.CONFLICT, "Database Exception: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleException(Exception ex) {
        return BaseResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred: " + ex.getMessage());
    }

}
