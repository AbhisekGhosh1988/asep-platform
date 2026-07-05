package com.abhisek.asep.requirements.infrastructure.persistence.mapper;

import com.abhisek.asep.requirements.domain.model.RequirementComment;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementCommentEntity;
import org.springframework.stereotype.Component;

@Component
public class RequirementCommentPersistenceMapper {

    public RequirementCommentEntity toEntity(RequirementComment domain) {

        if (domain == null) {
            return null;
        }

        return RequirementCommentEntity.builder().id(Long.valueOf(domain.getId())).requirementId(domain.getRequirementId()).comment(domain.getComment()).commentedBy(domain.getCommentedBy()).commentedAt(domain.getCommentedAt()).build();
    }

    public RequirementComment toDomain(RequirementCommentEntity entity) {

        if (entity == null) {
            return null;
        }

        return RequirementComment.builder().id(String.valueOf(entity.getId())).requirementId(entity.getRequirementId()).comment(entity.getComment()).commentedBy(entity.getCommentedBy()).commentedAt(entity.getCommentedAt()).build();
    }
}