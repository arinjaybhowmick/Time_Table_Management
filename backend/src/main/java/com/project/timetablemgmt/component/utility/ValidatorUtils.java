package com.project.timetablemgmt.component.utility;

import com.project.timetablemgmt.exception.ValidationException;
import com.project.timetablemgmt.framework.AbstractException;

public final class ValidatorUtils {

    private ValidatorUtils() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void validateFieldRegex(String field, String regex, String errorMessage) throws AbstractException {
        if (!field.matches(regex))
            throw new ValidationException(errorMessage);
    }

    public static void validateNotLessThan(int leftParam, int rightParam, String errorMessage) throws AbstractException {
        if (leftParam < rightParam)
            throw new ValidationException(errorMessage);
    }

    public static void validateNotLessThanEqual(int leftParam, int rightParam, String errorMessage) throws AbstractException {
        if (leftParam <= rightParam)
            throw new ValidationException(errorMessage);
    }

}
