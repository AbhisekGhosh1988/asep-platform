package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityRepository {

    Entity save(Entity entity);

    Optional<Entity> findById(String id);

    List<Entity> findByAggregateId(String aggregateId);

}