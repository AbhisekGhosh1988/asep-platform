package com.abhisek.asep.requirements.infrastructure.mapper;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementEntity;

public interface RequirementPersistenceMapper {
    RequirementEntity toEntity(Requirement requirement);
    Requirement toDomain(RequirementEntity entity);
}
