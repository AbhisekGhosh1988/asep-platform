package com.abhisek.asep.common.exception;

import com.abhisek.asep.common.enums.ErrorCode;

public class UnauthorizedException extends ASEPException {

    public UnauthorizedException(String message) {
        super(ErrorCode.UNAUTHORIZED, message);
    }
}