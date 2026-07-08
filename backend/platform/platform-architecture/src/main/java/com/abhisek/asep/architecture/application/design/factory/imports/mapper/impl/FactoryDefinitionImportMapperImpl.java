package com.abhisek.asep.architecture.application.design.factory.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.factory.imports.dto.request.FactoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.factory.imports.mapper.FactoryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import org.springframework.stereotype.Component;

@Component
public class FactoryDefinitionImportMapperImpl
        implements FactoryDefinitionImportMapper {

    @Override
    public FactoryDefinition toFactory(
            FactoryDefinitionImportRequest request) {

        if (request == null) {
            return null;
        }

        return FactoryDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}