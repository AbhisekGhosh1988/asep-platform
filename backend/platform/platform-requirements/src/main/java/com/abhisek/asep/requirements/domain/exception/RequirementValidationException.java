package com.abhisek.asep.requirements.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class RequirementValidationException  extends ASEPException {
    public RequirementValidationException(String message) {
        super(ErrorCode.INVALID_REQUIREMENT, message);
    }
}

