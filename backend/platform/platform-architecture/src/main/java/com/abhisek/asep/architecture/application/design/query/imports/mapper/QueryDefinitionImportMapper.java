package com.abhisek.asep.architecture.application.design.query.imports.mapper;

import com.abhisek.asep.architecture.application.design.query.imports.dto.request.QueryDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.QueryDefinition;

public interface QueryDefinitionImportMapper {

    QueryDefinition toQueryDefinition(
            QueryDefinitionImportRequest request);

}