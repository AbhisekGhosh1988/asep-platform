package com.abhisek.asep.architecture.application.design.query.imports.service;

import com.abhisek.asep.architecture.application.design.query.imports.dto.request.QueryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.query.imports.dto.response.QueryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.query.imports.mapper.QueryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import com.abhisek.asep.architecture.domain.repository.QueryDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QueryDefinitionImportServiceImpl extends AbstractCreateUseCase implements QueryDefinitionImportService {

    private final QueryDefinitionRepository repository;

    private final QueryDefinitionImportMapper mapper;

    @Override
    public QueryDefinitionImportResponse importQueryDefinition(QueryDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Query Definition already exists.");

        }

        QueryDefinition queryDefinition = mapper.toQueryDefinition(request);

        queryDefinition.setId(newId());

        queryDefinition.setCreatedAt(now());
        queryDefinition.setUpdatedAt(now());

        queryDefinition.setCreatedBy(currentUser());
        queryDefinition.setUpdatedBy(currentUser());

        queryDefinition = repository.save(queryDefinition);

        return QueryDefinitionImportResponse.builder().queryDefinitionId(queryDefinition.getId()).build();

    }

}