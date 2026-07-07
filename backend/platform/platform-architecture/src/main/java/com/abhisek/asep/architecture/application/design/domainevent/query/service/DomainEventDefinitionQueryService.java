package com.abhisek.asep.architecture.application.design.domainevent.query.service;

import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;

import java.util.List;

public interface DomainEventDefinitionQueryService {

    DomainEventDefinitionDetailsResponse getDomainEvent(
            String domainEventId);

    List<DomainEventDefinitionDetailsResponse> getDomainEvents(
            String aggregateId);

}