package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.DomainEventDefinitionEntity;

public interface DomainEventDefinitionPersistenceMapper {

    DomainEventDefinitionEntity toEntity(
            DomainEventDefinition domainEvent);

    DomainEventDefinition toDomain(
            DomainEventDefinitionEntity entity);

}