package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.request.ApproveRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface ApproveRequirementUseCase {

    RequirementResponse execute(
            String requirementId,
            ApproveRequirementRequest request);

}