package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.request.RejectRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface RejectRequirementUseCase {

    RequirementResponse execute(
            String requirementId,
            RejectRequirementRequest request);

}