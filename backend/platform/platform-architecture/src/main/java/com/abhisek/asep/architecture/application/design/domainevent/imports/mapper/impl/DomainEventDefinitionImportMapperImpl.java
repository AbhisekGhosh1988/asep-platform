package com.abhisek.asep.architecture.application.design.domainevent.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.request.DomainEventDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainevent.imports.mapper.DomainEventDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import org.springframework.stereotype.Component;

@Component
public class DomainEventDefinitionImportMapperImpl
        implements DomainEventDefinitionImportMapper {

    @Override
    public DomainEventDefinition toDomainEvent(
            DomainEventDefinitionImportRequest request) {

        return DomainEventDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}