package com.abhisek.asep.architecture.application.design.specification.imports.service;

import com.abhisek.asep.architecture.application.design.specification.imports.dto.request.SpecificationDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.specification.imports.dto.response.SpecificationDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.specification.imports.mapper.SpecificationDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import com.abhisek.asep.architecture.domain.repository.SpecificationDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpecificationDefinitionImportServiceImpl extends AbstractCreateUseCase implements SpecificationDefinitionImportService {

    private final SpecificationDefinitionRepository repository;

    private final SpecificationDefinitionImportMapper mapper;

    @Override
    public SpecificationDefinitionImportResponse importSpecification(SpecificationDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Specification already exists.");

        }

        SpecificationDefinition specification = mapper.toSpecification(request);

        specification.setId(newId());

        specification.setCreatedAt(now());
        specification.setUpdatedAt(now());

        specification.setCreatedBy(currentUser());
        specification.setUpdatedBy(currentUser());

        specification = repository.save(specification);

        return SpecificationDefinitionImportResponse.builder().specificationId(specification.getId()).build();

    }

}