package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;

import java.util.List;

public interface RequirementQueryService {

    RequirementResponse getById(
            String requirementId);

    List<RequirementSummaryResponse> list(
            String projectId);

}