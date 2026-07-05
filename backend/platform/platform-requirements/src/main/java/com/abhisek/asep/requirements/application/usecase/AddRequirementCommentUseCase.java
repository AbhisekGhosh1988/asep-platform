package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.request.AddRequirementCommentRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;

public interface AddRequirementCommentUseCase {

    RequirementCommentResponse execute(
            String requirementId,
            AddRequirementCommentRequest request);

}