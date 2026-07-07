package com.abhisek.asep.architecture.application.design.repository.query.service;

import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.repository.query.mapper.RepositoryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.RepositoryDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepositoryDefinitionQueryServiceImpl implements RepositoryDefinitionQueryService {

    private final RepositoryDefinitionRepository repository;

    private final RepositoryDefinitionQueryMapper mapper;

    @Override
    public RepositoryDefinitionDetailsResponse getRepositoryDefinition(String repositoryDefinitionId) {

        return repository.findById(repositoryDefinitionId).map(mapper::toResponse).orElseThrow(() -> new IllegalArgumentException("Repository Definition not found : " + repositoryDefinitionId));

    }

    @Override
    public List<RepositoryDefinitionDetailsResponse> getRepositoryDefinitions(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toResponse).toList();

    }

}