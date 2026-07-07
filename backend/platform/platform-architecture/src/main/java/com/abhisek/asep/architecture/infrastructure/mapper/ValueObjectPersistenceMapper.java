package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.ValueObject;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ValueObjectEntity;

public interface ValueObjectPersistenceMapper {

    ValueObjectEntity toEntity(ValueObject valueObject);

    ValueObject toDomain(ValueObjectEntity entity);

}