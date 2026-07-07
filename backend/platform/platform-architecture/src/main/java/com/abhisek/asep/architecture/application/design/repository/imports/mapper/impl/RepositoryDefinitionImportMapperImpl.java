package com.abhisek.asep.architecture.application.design.repository.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.repository.imports.dto.request.RepositoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.repository.imports.mapper.RepositoryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionImportMapperImpl
        implements RepositoryDefinitionImportMapper {

    @Override
    public RepositoryDefinition toRepositoryDefinition(
            RepositoryDefinitionImportRequest request) {

        return RepositoryDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}