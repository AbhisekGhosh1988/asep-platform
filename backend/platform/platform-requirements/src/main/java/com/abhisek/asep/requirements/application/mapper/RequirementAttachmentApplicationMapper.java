package com.abhisek.asep.requirements.application.mapper;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import com.abhisek.asep.requirements.domain.model.RequirementAttachment;

public interface RequirementAttachmentApplicationMapper {
    RequirementAttachmentResponse toResponse(
            RequirementAttachment attachment);
}
