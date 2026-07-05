package com.abhisek.asep.requirements.application.usecase;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadRequirementAttachmentUseCase {

    RequirementAttachmentResponse execute(
            String requirementId,
            MultipartFile file,
            String uploadedBy);

}