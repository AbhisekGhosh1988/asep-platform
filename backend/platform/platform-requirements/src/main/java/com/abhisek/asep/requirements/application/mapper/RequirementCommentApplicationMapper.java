package com.abhisek.asep.requirements.application.mapper;

import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;
import com.abhisek.asep.requirements.domain.model.RequirementComment;

public interface RequirementCommentApplicationMapper {
    RequirementCommentResponse toResponse(RequirementComment comment);
}
