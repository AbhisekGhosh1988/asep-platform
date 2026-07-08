package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.PolicyDefinition;

import java.util.List;
import java.util.Optional;

public interface PolicyDefinitionRepository {

    PolicyDefinition save(
            PolicyDefinition policy);

    Optional<PolicyDefinition> findById(
            String id);

    List<PolicyDefinition> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}