package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.FactoryDefinition;

import java.util.List;
import java.util.Optional;

public interface FactoryDefinitionRepository {

    FactoryDefinition save(
            FactoryDefinition factory);

    Optional<FactoryDefinition> findById(
            String id);

    List<FactoryDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}