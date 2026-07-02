package com.abhisek.asep.common.exception;

import com.abhisek.asep.common.enums.ErrorCode;

public class ASEPException extends RuntimeException {

    private final ErrorCode errorCode;

    public ASEPException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ASEPException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ASEPException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}