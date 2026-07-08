package com.abhisek.asep.architecture.application.design.query.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.query.imports.dto.request.QueryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.query.imports.mapper.QueryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import org.springframework.stereotype.Component;

@Component
public class QueryDefinitionImportMapperImpl
        implements QueryDefinitionImportMapper {

    @Override
    public QueryDefinition toQueryDefinition(
            QueryDefinitionImportRequest request) {

        if (request == null) {
            return null;
        }

        return QueryDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}