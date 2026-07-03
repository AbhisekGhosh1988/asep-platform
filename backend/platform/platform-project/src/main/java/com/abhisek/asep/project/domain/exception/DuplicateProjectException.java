package com.abhisek.asep.project.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class DuplicateProjectException extends ASEPException {

    public DuplicateProjectException(String message) {
        super(ErrorCode.CONFLICT, message);
    }

}