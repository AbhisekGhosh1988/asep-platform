package com.abhisek.asep.architecture.application.design.repository.query.mapper;

import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;

public interface RepositoryDefinitionQueryMapper {

    RepositoryDefinitionDetailsResponse toResponse(
            RepositoryDefinition repository);

}