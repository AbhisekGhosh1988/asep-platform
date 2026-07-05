package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface GetRequirementUseCase {

    RequirementResponse execute(String requirementId);

}