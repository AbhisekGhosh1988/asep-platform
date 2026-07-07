package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.ValueObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaValueObjectRepository extends JpaRepository<ValueObjectEntity, String> {

    List<ValueObjectEntity> findByAggregateId(String aggregateId);

    boolean existsByAggregateIdAndName(String aggregateId, String name);

}