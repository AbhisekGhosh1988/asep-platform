package com.abhisek.asep.identity.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class RoleNotFoundException extends ASEPException {

    public RoleNotFoundException(String message) {
        super(ErrorCode.ROLE_NOT_FOUND, message);
    }

}