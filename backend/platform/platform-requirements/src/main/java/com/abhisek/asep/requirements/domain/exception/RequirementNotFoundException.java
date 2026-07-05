package com.abhisek.asep.requirements.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class RequirementNotFoundException extends ASEPException {

    public RequirementNotFoundException(String message) {
        super(ErrorCode.REQUIREMENT_NOT_FOUND, message);
    }

}