package com.abhisek.asep.architecture.application.design.query.query.service;

import com.abhisek.asep.architecture.application.design.query.query.dto.QueryDefinitionDetailsResponse;

import java.util.List;

public interface QueryDefinitionQueryService {

    QueryDefinitionDetailsResponse getQueryDefinition(
            String queryDefinitionId);

    List<QueryDefinitionDetailsResponse> getQueryDefinitions(
            String aggregateId);

}