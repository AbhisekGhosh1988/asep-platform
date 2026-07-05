package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;

import java.util.List;

public interface ListRequirementCommentsUseCase {

    List<RequirementCommentResponse> execute(
            String requirementId);

}