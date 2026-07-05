package com.abhisek.asep.requirements.infrastructure.mapper;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementVersion;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementVersionEntity;
import jakarta.transaction.Transactional;

public interface RequirementVersionPersistenceMapper {
    RequirementVersionEntity toEntity(RequirementVersion version);
    public RequirementVersion toDomain(
            RequirementVersionEntity entity);

}
