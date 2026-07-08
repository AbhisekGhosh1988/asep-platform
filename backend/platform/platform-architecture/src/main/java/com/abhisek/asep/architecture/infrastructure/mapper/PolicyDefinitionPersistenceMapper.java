package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.PolicyDefinitionEntity;

public interface PolicyDefinitionPersistenceMapper {

    PolicyDefinitionEntity toEntity(
            PolicyDefinition policy);

    PolicyDefinition toDomain(
            PolicyDefinitionEntity entity);

}