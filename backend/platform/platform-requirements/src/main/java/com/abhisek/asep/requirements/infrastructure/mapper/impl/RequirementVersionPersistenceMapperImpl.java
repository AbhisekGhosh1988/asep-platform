package com.abhisek.asep.requirements.infrastructure.mapper.impl;

import com.abhisek.asep.requirements.domain.model.RequirementVersion;
import com.abhisek.asep.requirements.infrastructure.mapper.RequirementVersionPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementVersionEntity;
import org.springframework.stereotype.Component;

@Component
public class RequirementVersionPersistenceMapperImpl implements RequirementVersionPersistenceMapper {
    @Override
    public RequirementVersionEntity toEntity(RequirementVersion version) {
        if (version == null) {
            return null;
        }
        return RequirementVersionEntity.builder().id(String.valueOf(version.getId())).
                requirementId(String.valueOf(version.getRequirementId())).version(version.getVersion()).
                snapshot(version.getSnapshot()).createdBy(version.getCreatedBy()).
                createdAt(version.getCreatedAt()).build();

    }

    @Override
    public RequirementVersion toDomain(RequirementVersionEntity entity) {
        if (entity == null) {
            return null;
        }
        return RequirementVersion.builder().id(entity.getId()).requirementId(entity.getRequirementId()).
                version(entity.getVersion()).snapshot(entity.getSnapshot()).
                createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).build();
    }
}
