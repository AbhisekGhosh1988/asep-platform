package com.abhisek.asep.architecture.application.design.domainevent.imports.mapper;

import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.request.DomainEventDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;

public interface DomainEventDefinitionImportMapper {

    DomainEventDefinition toDomainEvent(
            DomainEventDefinitionImportRequest request);

}