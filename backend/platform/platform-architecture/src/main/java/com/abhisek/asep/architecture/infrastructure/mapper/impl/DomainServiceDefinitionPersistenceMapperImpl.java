package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.DomainServiceDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.DomainServiceDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class DomainServiceDefinitionPersistenceMapperImpl
        implements DomainServiceDefinitionPersistenceMapper {

    @Override
    public DomainServiceDefinitionEntity toEntity(
            DomainServiceDefinition domainService) {

        if (domainService == null) {
            return null;
        }

        return DomainServiceDefinitionEntity.builder()
                .id(domainService.getId())
                .aggregateId(domainService.getAggregateId())
                .name(domainService.getName())
                .description(domainService.getDescription())
                .createdBy(domainService.getCreatedBy())
                .createdAt(domainService.getCreatedAt())
                .updatedBy(domainService.getUpdatedBy())
                .updatedAt(domainService.getUpdatedAt())
                .build();

    }

    @Override
    public DomainServiceDefinition toDomain(
            DomainServiceDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return DomainServiceDefinition.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}