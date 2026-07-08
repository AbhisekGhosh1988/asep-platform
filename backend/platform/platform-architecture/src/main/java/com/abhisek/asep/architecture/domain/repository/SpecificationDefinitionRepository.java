package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;

import java.util.List;
import java.util.Optional;

public interface SpecificationDefinitionRepository {

    SpecificationDefinition save(
            SpecificationDefinition specification);

    Optional<SpecificationDefinition> findById(
            String id);

    List<SpecificationDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}