package com.abhisek.asep.requirements.infrastructure.mapper.impl;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.infrastructure.mapper.RequirementPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementEntity;
import org.springframework.stereotype.Component;

@Component
public class RequirementPersistenceMapperImpl implements RequirementPersistenceMapper {

    @Override
    public RequirementEntity toEntity(Requirement requirement) {

        if (requirement == null) {
            return null;
        }

        return RequirementEntity.builder()

                .id(requirement.getId()).projectId(requirement.getProjectId()).title(requirement.getTitle()).description(requirement.getDescription()).type(requirement.getType()).status(requirement.getStatus()).priority(requirement.getPriority()).complexity(requirement.getComplexity()).source(requirement.getSource()).risk(requirement.getRisk()).version(requirement.getVersion()).parentRequirementId(requirement.getParentRequirementId()).tags(requirement.getTags()).createdBy(requirement.getCreatedBy()).approvedBy(requirement.getApprovedBy())

                .build();
    }

    @Override
    public Requirement toDomain(RequirementEntity entity) {
        if (entity == null) {
            return null;
        }

        return Requirement.builder()

                .id(entity.getId()).projectId(entity.getProjectId()).title(entity.getTitle()).description(entity.getDescription()).type(entity.getType()).status(entity.getStatus()).priority(entity.getPriority()).complexity(entity.getComplexity()).source(entity.getSource()).risk(entity.getRisk()).version(entity.getVersion()).parentRequirementId(entity.getParentRequirementId()).tags(entity.getTags()).createdBy(entity.getCreatedBy()).approvedBy(entity.getApprovedBy()).build();

    }
}

