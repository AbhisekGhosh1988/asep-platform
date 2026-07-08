package com.abhisek.asep.architecture.application.design.query.imports.service;

import com.abhisek.asep.architecture.application.design.query.imports.dto.request.QueryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.query.imports.dto.response.QueryDefinitionImportResponse;

public interface QueryDefinitionImportService {

    QueryDefinitionImportResponse importQueryDefinition(
            QueryDefinitionImportRequest request);

}