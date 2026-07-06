package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Microservice;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.MicroserviceEntity;

public interface MicroservicePersistenceMapper {

    MicroserviceEntity toEntity(Microservice microservice);

    Microservice toDomain(MicroserviceEntity entity);

}