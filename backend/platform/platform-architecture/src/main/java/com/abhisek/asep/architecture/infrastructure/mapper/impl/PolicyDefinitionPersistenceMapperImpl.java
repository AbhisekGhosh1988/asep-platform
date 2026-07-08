package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.PolicyDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.PolicyDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class PolicyDefinitionPersistenceMapperImpl
        implements PolicyDefinitionPersistenceMapper {

    @Override
    public PolicyDefinitionEntity toEntity(
            PolicyDefinition policy) {

        if (policy == null) {
            return null;
        }

        return PolicyDefinitionEntity.builder()
                .id(policy.getId())
                .aggregateId(policy.getAggregateId())
                .name(policy.getName())
                .description(policy.getDescription())
                .createdBy(policy.getCreatedBy())
                .createdAt(policy.getCreatedAt())
                .updatedBy(policy.getUpdatedBy())
                .updatedAt(policy.getUpdatedAt())
                .build();

    }

    @Override
    public PolicyDefinition toDomain(
            PolicyDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return PolicyDefinition.builder()
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