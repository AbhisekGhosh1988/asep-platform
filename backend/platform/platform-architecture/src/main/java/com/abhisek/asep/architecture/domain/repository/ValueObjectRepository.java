package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.ValueObject;

import java.util.List;
import java.util.Optional;

public interface ValueObjectRepository {

    ValueObject save(ValueObject valueObject);

    Optional<ValueObject> findById(String id);

    List<ValueObject> findByAggregateId(String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}