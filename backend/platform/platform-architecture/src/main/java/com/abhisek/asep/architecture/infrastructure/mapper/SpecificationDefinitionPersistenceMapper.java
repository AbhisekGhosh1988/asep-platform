package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.SpecificationDefinitionEntity;

public interface SpecificationDefinitionPersistenceMapper {

    SpecificationDefinitionEntity toEntity(
            SpecificationDefinition specification);

    SpecificationDefinition toDomain(
            SpecificationDefinitionEntity entity);

}