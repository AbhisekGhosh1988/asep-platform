package com.abhisek.asep.architecture.application.design.factory.imports.service;

import com.abhisek.asep.architecture.application.design.factory.imports.dto.request.FactoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.factory.imports.dto.response.FactoryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.factory.imports.mapper.FactoryDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import com.abhisek.asep.architecture.domain.repository.FactoryDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FactoryDefinitionImportServiceImpl
        extends AbstractCreateUseCase
        implements FactoryDefinitionImportService {

    private final FactoryDefinitionRepository repository;

    private final FactoryDefinitionImportMapper mapper;

    @Override
    public FactoryDefinitionImportResponse importFactory(
            FactoryDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(
                request.getAggregateId(),
                request.getName())) {

            throw new IllegalArgumentException(
                    "Factory Definition already exists.");

        }

        FactoryDefinition factory =
                mapper.toFactory(request);

        factory.setId(newId());

        factory.setCreatedAt(now());
        factory.setUpdatedAt(now());

        factory.setCreatedBy(currentUser());
        factory.setUpdatedBy(currentUser());

        factory = repository.save(factory);

        return FactoryDefinitionImportResponse.builder()
                .factoryId(factory.getId())
                .build();

    }

}