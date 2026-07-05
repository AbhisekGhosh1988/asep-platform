package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;

import java.util.List;

public interface ListRequirementsUseCase {

    List<RequirementSummaryResponse> execute(String projectId);

}