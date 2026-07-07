package com.abhisek.asep.architecture.application.design.attribute.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.mapper.AttributeQueryMapper;
import com.abhisek.asep.architecture.domain.model.Attribute;
import org.springframework.stereotype.Component;

@Component
public class AttributeQueryMapperImpl
        implements AttributeQueryMapper {

    @Override
    public AttributeDetailsResponse toResponse(Attribute attribute) {

        if (attribute == null) {
            return null;
        }

        return AttributeDetailsResponse.builder()
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
                .build();

    }

}