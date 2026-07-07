package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Attribute;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.AttributeEntity;

public interface AttributePersistenceMapper {

    AttributeEntity toEntity(Attribute attribute);

    Attribute toDomain(AttributeEntity entity);

}