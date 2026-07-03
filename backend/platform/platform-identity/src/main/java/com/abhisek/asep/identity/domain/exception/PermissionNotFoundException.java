package com.abhisek.asep.identity.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class PermissionNotFoundException extends ASEPException {

    public PermissionNotFoundException(String message) {
        super(ErrorCode.PERMISSION_NOT_FOUND, message);
    }

}