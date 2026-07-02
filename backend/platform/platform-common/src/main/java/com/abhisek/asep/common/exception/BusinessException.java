package com.abhisek.asep.common.exception;

import com.abhisek.asep.common.enums.ErrorCode;

public class BusinessException extends ASEPException {

    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}