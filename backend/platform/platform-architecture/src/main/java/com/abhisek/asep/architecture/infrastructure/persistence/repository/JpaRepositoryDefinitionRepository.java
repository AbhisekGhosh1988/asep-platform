package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.RepositoryDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRepositoryDefinitionRepository
        extends JpaRepository<RepositoryDefinitionEntity, String> {

    List<RepositoryDefinitionEntity> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}