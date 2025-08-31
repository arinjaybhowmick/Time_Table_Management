package com.project.timetablemgmt.utility;

import org.springframework.util.ObjectUtils;

import com.project.timetablemgmt.exception.ValidationException;
import com.project.timetablemgmt.framework.AbstractException;

public final class ValidatorUtils {

    private ValidatorUtils() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void validateNotNull(Object field, String errorMessage) throws AbstractException {
        if (ObjectUtils.isEmpty(field))
            throw new ValidationException(errorMessage);
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
