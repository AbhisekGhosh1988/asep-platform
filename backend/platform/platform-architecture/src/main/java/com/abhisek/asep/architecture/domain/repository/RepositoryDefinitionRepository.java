package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;

import java.util.List;
import java.util.Optional;

public interface RepositoryDefinitionRepository {

    RepositoryDefinition save(RepositoryDefinition repository);

    Optional<RepositoryDefinition> findById(String id);

    List<RepositoryDefinition> findByAggregateId(String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}