package com.abhisek.asep.architecture.application.design.domainevent.query.service;

import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainevent.query.mapper.DomainEventDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.DomainEventDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainEventDefinitionQueryServiceImpl
        implements DomainEventDefinitionQueryService {

    private final DomainEventDefinitionRepository repository;

    private final DomainEventDefinitionQueryMapper mapper;

    @Override
    public DomainEventDefinitionDetailsResponse getDomainEvent(
            String domainEventId) {

        return repository.findById(domainEventId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Domain Event not found : "
                                        + domainEventId));

    }

    @Override
    public List<DomainEventDefinitionDetailsResponse> getDomainEvents(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}