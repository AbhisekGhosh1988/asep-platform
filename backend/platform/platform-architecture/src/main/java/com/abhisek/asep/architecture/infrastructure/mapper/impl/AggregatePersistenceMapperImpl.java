package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Aggregate;
import com.abhisek.asep.architecture.infrastructure.mapper.AggregatePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.AggregateEntity;
import org.springframework.stereotype.Component;

@Component
public class AggregatePersistenceMapperImpl implements AggregatePersistenceMapper {

    @Override
    public AggregateEntity toEntity(Aggregate aggregate) {

        if (aggregate == null) {
            return null;
        }

        return AggregateEntity.builder().id(aggregate.getId()).microserviceId(aggregate.getMicroserviceId()).name(aggregate.getName()).description(aggregate.getDescription()).createdBy(aggregate.getCreatedBy()).createdAt(aggregate.getCreatedAt()).updatedBy(aggregate.getUpdatedBy()).updatedAt(aggregate.getUpdatedAt()).build();

    }

    @Override
    public Aggregate toDomain(AggregateEntity entity) {

        if (entity == null) {
            return null;
        }

        return Aggregate.builder().id(entity.getId()).microserviceId(entity.getMicroserviceId()).name(entity.getName()).description(entity.getDescription()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).updatedBy(entity.getUpdatedBy()).updatedAt(entity.getUpdatedAt()).build();

    }

}