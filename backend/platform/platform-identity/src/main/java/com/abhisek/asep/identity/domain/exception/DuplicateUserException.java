package com.abhisek.asep.identity.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class DuplicateUserException extends ASEPException {

    public DuplicateUserException(String message) {
        super(ErrorCode.USER_ALREADY_EXISTS, message);
    }

}