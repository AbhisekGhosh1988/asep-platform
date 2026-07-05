package com.abhisek.asep.requirements.application.mapper.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementAttachmentApplicationMapper;
import com.abhisek.asep.requirements.domain.model.RequirementAttachment;
import org.springframework.stereotype.Component;

@Component
public class RequirementAttachmentApplicationMapperImpl implements RequirementAttachmentApplicationMapper {
    @Override
    public RequirementAttachmentResponse toResponse(RequirementAttachment attachment) {
        if (attachment == null) {
            return null;
        }

        return RequirementAttachmentResponse.builder().id(attachment.getId()).requirementId(attachment.getRequirementId()).fileName(attachment.getFileName()).originalFileName(attachment.getOriginalFileName()).contentType(attachment.getContentType()).fileSize(attachment.getFileSize()).uploadedBy(attachment.getUploadedBy()).uploadedAt(attachment.getUploadedAt()).build();
    }
}

