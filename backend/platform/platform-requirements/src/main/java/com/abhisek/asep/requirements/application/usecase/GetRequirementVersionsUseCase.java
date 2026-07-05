package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;

import java.util.List;

public interface GetRequirementVersionsUseCase {

    List<RequirementVersionResponse> execute(String requirementId);

}