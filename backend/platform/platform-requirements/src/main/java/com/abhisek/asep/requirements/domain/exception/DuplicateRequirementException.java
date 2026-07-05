package com.abhisek.asep.requirements.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class DuplicateRequirementException extends ASEPException {
    public DuplicateRequirementException(String message) {
        super(ErrorCode.DUPLICATE_REQUIREMENT, message);
    }
}

