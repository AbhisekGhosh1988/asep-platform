package com.abhisek.asep.architecture.application.design.repository.query.service;

import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;

import java.util.List;

public interface RepositoryDefinitionQueryService {

    RepositoryDefinitionDetailsResponse getRepositoryDefinition(
            String repositoryDefinitionId);

    List<RepositoryDefinitionDetailsResponse> getRepositoryDefinitions(
            String aggregateId);

}