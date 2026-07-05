package com.abhisek.asep.requirements.infrastructure.persistence.mapper;

import com.abhisek.asep.requirements.domain.model.RequirementAttachment;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementAttachmentEntity;
import org.springframework.stereotype.Component;

@Component
public class RequirementAttachmentPersistenceMapper {

    public RequirementAttachmentEntity toEntity(RequirementAttachment domain) {

        if (domain == null) {
            return null;
        }

        return RequirementAttachmentEntity.builder().id(domain.getId()).requirementId(domain.getRequirementId()).fileName(domain.getFileName()).originalFileName(domain.getOriginalFileName()).contentType(domain.getContentType()).fileSize(domain.getFileSize()).storagePath(domain.getStoragePath()).uploadedBy(domain.getUploadedBy()).uploadedAt(domain.getUploadedAt()).build();
    }

    public RequirementAttachment toDomain(RequirementAttachmentEntity entity) {

        if (entity == null) {
            return null;
        }

        return RequirementAttachment.builder().id(entity.getId()).requirementId(entity.getRequirementId()).fileName(entity.getFileName()).originalFileName(entity.getOriginalFileName()).contentType(entity.getContentType()).fileSize(entity.getFileSize()).storagePath(entity.getStoragePath()).uploadedBy(entity.getUploadedBy()).uploadedAt(entity.getUploadedAt()).build();
    }
}