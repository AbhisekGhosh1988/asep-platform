package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.DomainEventDefinition;

import java.util.List;
import java.util.Optional;

public interface DomainEventDefinitionRepository {

    DomainEventDefinition save(
            DomainEventDefinition domainEvent);

    Optional<DomainEventDefinition> findById(
            String id);

    List<DomainEventDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}