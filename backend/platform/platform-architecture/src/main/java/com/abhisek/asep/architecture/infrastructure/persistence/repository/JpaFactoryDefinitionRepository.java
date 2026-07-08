package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.FactoryDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaFactoryDefinitionRepository
        extends JpaRepository<FactoryDefinitionEntity, String> {

    List<FactoryDefinitionEntity> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}