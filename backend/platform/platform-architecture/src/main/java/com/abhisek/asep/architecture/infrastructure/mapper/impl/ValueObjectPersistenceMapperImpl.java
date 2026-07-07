package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.ValueObject;
import com.abhisek.asep.architecture.infrastructure.mapper.ValueObjectPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ValueObjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectPersistenceMapperImpl
        implements ValueObjectPersistenceMapper {

    @Override
    public ValueObjectEntity toEntity(
            ValueObject valueObject) {

        if (valueObject == null) {
            return null;
        }

        return ValueObjectEntity.builder()
                .id(valueObject.getId())
                .aggregateId(valueObject.getAggregateId())
                .name(valueObject.getName())
                .description(valueObject.getDescription())
                .immutable(valueObject.getImmutable())
                .createdBy(valueObject.getCreatedBy())
                .createdAt(valueObject.getCreatedAt())
                .updatedBy(valueObject.getUpdatedBy())
                .updatedAt(valueObject.getUpdatedAt())
                .build();

    }

    @Override
    public ValueObject toDomain(
            ValueObjectEntity entity) {

        if (entity == null) {
            return null;
        }

        return ValueObject.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .immutable(entity.getImmutable())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}