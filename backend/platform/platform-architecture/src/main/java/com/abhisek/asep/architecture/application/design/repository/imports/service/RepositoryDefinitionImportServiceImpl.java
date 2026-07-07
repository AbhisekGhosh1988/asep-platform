package com.abhisek.asep.architecture.application.design.repository.imports.service;

import com.abhisek.asep.architecture.application.design.repository.imports.dto.request.RepositoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.repository.imports.dto.response.RepositoryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.repository.imports.mapper.RepositoryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import com.abhisek.asep.architecture.domain.repository.RepositoryDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RepositoryDefinitionImportServiceImpl extends AbstractCreateUseCase implements RepositoryDefinitionImportService {

    private final RepositoryDefinitionRepository repository;

    private final RepositoryDefinitionImportMapper mapper;

    @Override
    public RepositoryDefinitionImportResponse importRepositoryDefinition(RepositoryDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Repository Definition already exists.");

        }

        RepositoryDefinition definition = mapper.toRepositoryDefinition(request);

        definition.setId(newId());

        definition.setCreatedAt(now());
        definition.setUpdatedAt(now());

        definition.setCreatedBy(currentUser());
        definition.setUpdatedBy(currentUser());

        definition = repository.save(definition);

        return RepositoryDefinitionImportResponse.builder().repositoryDefinitionId(definition.getId()).build();

    }

}