package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface CreateRequirementUseCase {

    RequirementResponse execute(
            String projectId,
            CreateRequirementRequest request);

}