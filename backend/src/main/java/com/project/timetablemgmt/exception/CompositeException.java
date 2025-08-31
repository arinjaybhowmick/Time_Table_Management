package com.project.timetablemgmt.exception;

import java.util.List;

import com.project.timetablemgmt.framework.AbstractException;

import lombok.Getter;

@Getter
public class CompositeException extends AbstractException {

    private final List<AbstractException> exceptions;

    public CompositeException(List<AbstractException> exceptions) {
        super(exceptions.size() + " Exceptions Occurred");
        this.exceptions = exceptions;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        for (int i = 0; i < exceptions.size(); i++) {
            AbstractException e = exceptions.get(i);
            sb.append("\n  ").append(i + 1).append(". ").append(e.getClass().getSimpleName())
                    .append(": ").append(e.getMessage());
        }
        return sb.toString();
    }
}
