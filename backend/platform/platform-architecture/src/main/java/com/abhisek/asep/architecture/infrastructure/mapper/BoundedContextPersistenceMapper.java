package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.BoundedContextEntity;

public interface BoundedContextPersistenceMapper {

    BoundedContextEntity toEntity(BoundedContext boundedContext);

    BoundedContext toDomain(BoundedContextEntity entity);

}