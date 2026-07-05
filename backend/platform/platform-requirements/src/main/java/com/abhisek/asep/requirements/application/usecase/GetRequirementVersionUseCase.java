package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;

public interface GetRequirementVersionUseCase {

    RequirementVersionResponse execute(
            String requirementId,
            Integer version);

}