package com.abhisek.asep.architecture.application.design.repository.imports.service;

import com.abhisek.asep.architecture.application.design.repository.imports.dto.request.RepositoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.repository.imports.dto.response.RepositoryDefinitionImportResponse;

public interface RepositoryDefinitionImportService {

    RepositoryDefinitionImportResponse importRepositoryDefinition(
            RepositoryDefinitionImportRequest request);

}