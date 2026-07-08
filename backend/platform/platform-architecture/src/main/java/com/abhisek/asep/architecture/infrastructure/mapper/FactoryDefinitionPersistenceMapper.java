package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.FactoryDefinitionEntity;

public interface FactoryDefinitionPersistenceMapper {

    FactoryDefinitionEntity toEntity(
            FactoryDefinition factoryDefinition);

    FactoryDefinition toDomain(
            FactoryDefinitionEntity entity);

}