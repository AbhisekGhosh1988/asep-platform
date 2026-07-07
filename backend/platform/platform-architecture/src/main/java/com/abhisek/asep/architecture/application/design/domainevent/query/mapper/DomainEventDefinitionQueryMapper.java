package com.abhisek.asep.architecture.application.design.domainevent.query.mapper;

import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;

public interface DomainEventDefinitionQueryMapper {

    DomainEventDefinitionDetailsResponse toResponse(
            DomainEventDefinition domainEvent);

}