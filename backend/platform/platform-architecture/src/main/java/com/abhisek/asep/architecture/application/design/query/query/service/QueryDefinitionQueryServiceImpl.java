package com.abhisek.asep.architecture.application.design.query.query.service;

import com.abhisek.asep.architecture.application.design.query.query.dto.QueryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.query.mapper.QueryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.QueryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryDefinitionQueryServiceImpl
        implements QueryDefinitionQueryService {

    private final QueryDefinitionRepository repository;

    private final QueryDefinitionQueryMapper mapper;

    @Override
    public QueryDefinitionDetailsResponse getQueryDefinition(
            String queryDefinitionId) {

        return repository.findById(queryDefinitionId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Query Definition not found : "
                                        + queryDefinitionId));

    }

    @Override
    public List<QueryDefinitionDetailsResponse> getQueryDefinitions(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}