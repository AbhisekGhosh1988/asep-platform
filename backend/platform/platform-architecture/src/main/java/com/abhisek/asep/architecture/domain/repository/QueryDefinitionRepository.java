package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.QueryDefinition;

import java.util.List;
import java.util.Optional;

public interface QueryDefinitionRepository {

    QueryDefinition save(
            QueryDefinition queryDefinition);

    Optional<QueryDefinition> findById(
            String id);

    List<QueryDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}