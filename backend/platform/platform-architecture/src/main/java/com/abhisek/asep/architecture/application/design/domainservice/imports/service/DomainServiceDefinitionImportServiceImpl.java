package com.abhisek.asep.architecture.application.design.domainservice.imports.service;

import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.request.DomainServiceDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.response.DomainServiceDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.domainservice.imports.mapper.DomainServiceDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;
import com.abhisek.asep.architecture.domain.repository.DomainServiceDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DomainServiceDefinitionImportServiceImpl extends AbstractCreateUseCase implements DomainServiceDefinitionImportService {

    private final DomainServiceDefinitionRepository repository;

    private final DomainServiceDefinitionImportMapper mapper;

    @Override
    public DomainServiceDefinitionImportResponse importDomainService(DomainServiceDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Domain Service already exists.");

        }

        DomainServiceDefinition domainService = mapper.toDomainService(request);

        domainService.setId(newId());

        domainService.setCreatedAt(now());
        domainService.setUpdatedAt(now());

        domainService.setCreatedBy(currentUser());
        domainService.setUpdatedBy(currentUser());

        domainService = repository.save(domainService);

        return DomainServiceDefinitionImportResponse.builder().domainServiceId(domainService.getId()).build();

    }

}