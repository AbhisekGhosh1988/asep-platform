package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.ApiContract;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ApiContractEntity;

public interface ApiContractPersistenceMapper {

    ApiContractEntity toEntity(
            ApiContract apiContract);

    ApiContract toDomain(
            ApiContractEntity entity);

}