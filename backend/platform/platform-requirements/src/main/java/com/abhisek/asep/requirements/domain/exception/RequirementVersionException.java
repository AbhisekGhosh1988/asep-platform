package com.abhisek.asep.requirements.domain.exception;

public class RequirementVersionException extends RuntimeException {

    public RequirementVersionException(String message) {
        super(message);
    }

    public RequirementVersionException(String message, Throwable cause) {
        super(message, cause);
    }
}