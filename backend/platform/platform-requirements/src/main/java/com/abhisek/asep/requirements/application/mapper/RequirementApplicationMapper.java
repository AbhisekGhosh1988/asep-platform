package com.abhisek.asep.requirements.application.mapper;

import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;
import com.abhisek.asep.requirements.domain.model.Requirement;

public interface RequirementApplicationMapper {
    Requirement toDomain(CreateRequirementRequest request);

    void updateDomain(Requirement requirement, UpdateRequirementRequest request);

    RequirementResponse toResponse(Requirement requirement);

    RequirementSummaryResponse toSummary(Requirement requirement);
}
