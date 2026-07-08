package com.abhisek.asep.architecture.application.design.query.query.mapper;

import com.abhisek.asep.architecture.application.design.query.query.dto.QueryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.QueryDefinition;

public interface QueryDefinitionQueryMapper {

    QueryDefinitionDetailsResponse toResponse(
            QueryDefinition queryDefinition);

}