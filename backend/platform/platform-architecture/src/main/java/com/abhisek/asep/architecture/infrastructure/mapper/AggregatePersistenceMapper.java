package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Aggregate;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.AggregateEntity;

public interface AggregatePersistenceMapper {

    AggregateEntity toEntity(Aggregate aggregate);

    Aggregate toDomain(AggregateEntity entity);

}