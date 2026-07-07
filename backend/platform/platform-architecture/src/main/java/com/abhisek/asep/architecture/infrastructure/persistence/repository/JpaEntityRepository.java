package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.EntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaEntityRepository
        extends JpaRepository<EntityEntity, String> {

    List<EntityEntity> findByAggregateId(String aggregateId);

}