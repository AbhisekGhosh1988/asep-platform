package com.abhisek.asep.project.domain.exception;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;

public class ProjectNotFoundException extends ASEPException {

    public ProjectNotFoundException(String message) {
        super(ErrorCode.RESOURCE_NOT_FOUND, message);
    }

}