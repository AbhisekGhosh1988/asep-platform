package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface UpdateRequirementUseCase {

    RequirementResponse execute(
            String requirementId,
            UpdateRequirementRequest request);

}