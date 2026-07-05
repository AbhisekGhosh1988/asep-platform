package com.abhisek.asep.requirements.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class RequirementApprovalException extends ASEPException {
    public RequirementApprovalException(String message) {
        super(ErrorCode.REQUIREMENT_APPROVAL_FAILED, message);
    }
}

