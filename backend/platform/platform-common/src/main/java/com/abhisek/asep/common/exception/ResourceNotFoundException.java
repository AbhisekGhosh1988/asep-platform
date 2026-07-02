package com.abhisek.asep.common.exception;

import com.abhisek.asep.common.enums.ErrorCode;

public class ResourceNotFoundException extends ASEPException {

    public ResourceNotFoundException(String message) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message);
    }
}