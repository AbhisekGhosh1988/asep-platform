package com.abhisek.asep.architecture.application.design.query.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.query.query.dto.QueryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.query.mapper.QueryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import org.springframework.stereotype.Component;

@Component
public class QueryDefinitionQueryMapperImpl
        implements QueryDefinitionQueryMapper {

    @Override
    public QueryDefinitionDetailsResponse toResponse(
            QueryDefinition queryDefinition) {

        if (queryDefinition == null) {
            return null;
        }

        return QueryDefinitionDetailsResponse.builder()
                .id(queryDefinition.getId())
                .aggregateId(queryDefinition.getAggregateId())
                .name(queryDefinition.getName())
                .description(queryDefinition.getDescription())
                .build();

    }

}