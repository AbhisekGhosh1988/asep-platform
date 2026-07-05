package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;

import java.util.List;

public interface ListRequirementAttachmentsUseCase {

    List<RequirementAttachmentResponse> execute(
            String requirementId);

}