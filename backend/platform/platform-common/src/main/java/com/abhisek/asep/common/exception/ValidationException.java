package com.abhisek.asep.common.exception;

import com.abhisek.asep.common.enums.ErrorCode;

public class ValidationException extends ASEPException {

    public ValidationException(String message) {
        super(ErrorCode.VALIDATION_FAILED, message);
    }
}