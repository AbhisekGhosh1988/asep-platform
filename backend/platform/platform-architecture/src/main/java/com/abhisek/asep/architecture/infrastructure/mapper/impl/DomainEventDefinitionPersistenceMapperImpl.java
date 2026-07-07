package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.DomainEventDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.DomainEventDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class DomainEventDefinitionPersistenceMapperImpl implements DomainEventDefinitionPersistenceMapper {

    @Override
    public DomainEventDefinitionEntity toEntity(DomainEventDefinition domainEvent) {

        if (domainEvent == null) {
            return null;
        }

        return DomainEventDefinitionEntity.builder().id(domainEvent.getId()).aggregateId(domainEvent.getAggregateId()).name(domainEvent.getName()).description(domainEvent.getDescription()).createdBy(domainEvent.getCreatedBy()).createdAt(domainEvent.getCreatedAt()).updatedBy(domainEvent.getUpdatedBy()).updatedAt(domainEvent.getUpdatedAt()).build();

    }

    @Override
    public DomainEventDefinition toDomain(DomainEventDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return DomainEventDefinition.builder().id(entity.getId()).aggregateId(entity.getAggregateId()).name(entity.getName()).description(entity.getDescription()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).updatedBy(entity.getUpdatedBy()).updatedAt(entity.getUpdatedAt()).build();

    }

}