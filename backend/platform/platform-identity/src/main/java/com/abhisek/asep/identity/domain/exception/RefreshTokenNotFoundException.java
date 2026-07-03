package com.abhisek.asep.identity.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class RefreshTokenNotFoundException extends ASEPException {

    public RefreshTokenNotFoundException(String message) {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND, message);
    }

}