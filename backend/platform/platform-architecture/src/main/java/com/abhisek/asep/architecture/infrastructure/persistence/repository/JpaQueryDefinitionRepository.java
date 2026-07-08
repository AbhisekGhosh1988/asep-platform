package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.QueryDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaQueryDefinitionRepository
        extends JpaRepository<QueryDefinitionEntity, String> {

    List<QueryDefinitionEntity> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}