package com.abhisek.asep.architecture.domain.repository;


import com.abhisek.asep.architecture.domain.model.CommandDefinition;

import java.util.List;
import java.util.Optional;

public interface CommandDefinitionRepository {

    CommandDefinition save(
            CommandDefinition command);

    Optional<CommandDefinition> findById(
            String id);

    List<CommandDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}