package com.abhisek.asep.architecture.application.design.domainevent.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainevent.query.mapper.DomainEventDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;
import org.springframework.stereotype.Component;

@Component
public class DomainEventDefinitionQueryMapperImpl
        implements DomainEventDefinitionQueryMapper {

    @Override
    public DomainEventDefinitionDetailsResponse toResponse(
            DomainEventDefinition domainEvent) {

        if (domainEvent == null) {
            return null;
        }

        return DomainEventDefinitionDetailsResponse.builder()
                .id(domainEvent.getId())
                .aggregateId(domainEvent.getAggregateId())
                .name(domainEvent.getName())
                .description(domainEvent.getDescription())
                .build();

    }

}