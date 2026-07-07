package com.abhisek.asep.architecture.application.design.repository.imports.mapper;

import com.abhisek.asep.architecture.application.design.repository.imports.dto.request.RepositoryDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;

public interface RepositoryDefinitionImportMapper {

    RepositoryDefinition toRepositoryDefinition(
            RepositoryDefinitionImportRequest request);

}