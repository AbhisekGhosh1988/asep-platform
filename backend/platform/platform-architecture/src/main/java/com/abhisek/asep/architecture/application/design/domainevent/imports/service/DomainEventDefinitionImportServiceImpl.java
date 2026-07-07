package com.abhisek.asep.architecture.application.design.domainevent.imports.service;

import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.request.DomainEventDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.response.DomainEventDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.domainevent.imports.mapper.DomainEventDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import com.abhisek.asep.architecture.domain.repository.DomainEventDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DomainEventDefinitionImportServiceImpl
        extends AbstractCreateUseCase
        implements DomainEventDefinitionImportService {

    private final DomainEventDefinitionRepository repository;

    private final DomainEventDefinitionImportMapper mapper;

    @Override
    public DomainEventDefinitionImportResponse importDomainEvent(
            DomainEventDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(
                request.getAggregateId(),
                request.getName())) {

            throw new IllegalArgumentException(
                    "Domain Event already exists.");

        }

        DomainEventDefinition domainEvent =
                mapper.toDomainEvent(request);

        domainEvent.setId(newId());

        domainEvent.setCreatedAt(now());
        domainEvent.setUpdatedAt(now());

        domainEvent.setCreatedBy(currentUser());
        domainEvent.setUpdatedBy(currentUser());

        domainEvent = repository.save(domainEvent);

        return DomainEventDefinitionImportResponse.builder()
                .domainEventId(domainEvent.getId())
                .build();

    }

}