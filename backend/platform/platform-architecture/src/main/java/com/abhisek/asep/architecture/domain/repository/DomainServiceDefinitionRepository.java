package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.DomainServiceDefinition;

import java.util.List;
import java.util.Optional;

public interface DomainServiceDefinitionRepository {

    DomainServiceDefinition save(
            DomainServiceDefinition domainService);

    Optional<DomainServiceDefinition> findById(
            String id);

    List<DomainServiceDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}