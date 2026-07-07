package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Attribute;
import com.abhisek.asep.architecture.infrastructure.mapper.AttributePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.AttributeEntity;
import org.springframework.stereotype.Component;

@Component
public class AttributePersistenceMapperImpl
        implements AttributePersistenceMapper {

    @Override
    public AttributeEntity toEntity(
            Attribute attribute) {

        if (attribute == null) {
            return null;
        }

        return AttributeEntity.builder()
                .id(attribute.getId())
                .entityId(attribute.getEntityId())
                .name(attribute.getName())
                .dataType(attribute.getDataType())
                .required(attribute.getRequired())
                .nullable(attribute.getNullable())
                .unique(attribute.getUnique())
                .collection(attribute.getCollection())
                .defaultValue(attribute.getDefaultValue())
                .length(attribute.getLength())
                .precision(attribute.getPrecision())
                .scale(attribute.getScale())
                .description(attribute.getDescription())
                .createdBy(attribute.getCreatedBy())
                .createdAt(attribute.getCreatedAt())
                .updatedBy(attribute.getUpdatedBy())
                .updatedAt(attribute.getUpdatedAt())
                .build();

    }

    @Override
    public Attribute toDomain(
            AttributeEntity entity) {

        if (entity == null) {
            return null;
        }

        return Attribute.builder()
                .id(entity.getId())
                .entityId(entity.getEntityId())
                .name(entity.getName())
                .dataType(entity.getDataType())
                .required(entity.getRequired())
                .nullable(entity.getNullable())
                .unique(entity.getUnique())
                .collection(entity.getCollection())
                .defaultValue(entity.getDefaultValue())
                .length(entity.getLength())
                .precision(entity.getPrecision())
                .scale(entity.getScale())
                .description(entity.getDescription())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}