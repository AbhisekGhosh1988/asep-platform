package com.abhisek.asep.requirements.application.mapper;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;
import com.abhisek.asep.requirements.domain.model.RequirementVersion;

public interface RequirementVersionApplicationMapper {
    RequirementVersionResponse toResponse(
            RequirementVersion version);
}
