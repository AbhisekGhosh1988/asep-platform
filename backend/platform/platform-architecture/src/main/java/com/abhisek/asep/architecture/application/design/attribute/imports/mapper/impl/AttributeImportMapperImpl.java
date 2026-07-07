package com.abhisek.asep.architecture.application.design.attribute.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.attribute.imports.dto.request.AttributeImportRequest;
import com.abhisek.asep.architecture.application.design.attribute.imports.mapper.AttributeImportMapper;
import com.abhisek.asep.architecture.domain.model.Attribute;
import org.springframework.stereotype.Component;

@Component
public class AttributeImportMapperImpl
        implements AttributeImportMapper {

    @Override
    public Attribute toAttribute(
            AttributeImportRequest request) {

        return Attribute.builder()
                .entityId(request.getEntityId())
                .name(request.getName())
                .dataType(request.getDataType())
                .required(request.getRequired())
                .nullable(request.getNullable())
                .unique(request.getUnique())
                .collection(request.getCollection())
                .defaultValue(request.getDefaultValue())
                .length(request.getLength())
                .precision(request.getPrecision())
                .scale(request.getScale())
                .description(request.getDescription())
                .build();

    }

}