package com.abhisek.asep.architecture.application.design.specification.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.specification.imports.dto.request.SpecificationDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.specification.imports.mapper.SpecificationDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import org.springframework.stereotype.Component;

@Component
public class SpecificationDefinitionImportMapperImpl
        implements SpecificationDefinitionImportMapper {

    @Override
    public SpecificationDefinition toSpecification(
            SpecificationDefinitionImportRequest request) {

        if (request == null) {
            return null;
        }

        return SpecificationDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}