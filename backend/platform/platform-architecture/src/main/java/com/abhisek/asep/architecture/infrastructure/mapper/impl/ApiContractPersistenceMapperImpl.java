package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.ApiContract;
import com.abhisek.asep.architecture.infrastructure.mapper.ApiContractPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ApiContractEntity;
import org.springframework.stereotype.Component;

@Component
public class ApiContractPersistenceMapperImpl
        implements ApiContractPersistenceMapper {

    @Override
    public ApiContractEntity toEntity(
            ApiContract apiContract) {

        if (apiContract == null) {
            return null;
        }

        return ApiContractEntity.builder()
                .id(apiContract.getId())
                .aggregateId(apiContract.getAggregateId())
                .name(apiContract.getName())
                .method(apiContract.getMethod())
                .path(apiContract.getPath())
                .description(apiContract.getDescription())
                .createdBy(apiContract.getCreatedBy())
                .createdAt(apiContract.getCreatedAt())
                .updatedBy(apiContract.getUpdatedBy())
                .updatedAt(apiContract.getUpdatedAt())
                .build();

    }

    @Override
    public ApiContract toDomain(
            ApiContractEntity entity) {

        if (entity == null) {
            return null;
        }

        return ApiContract.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .method(entity.getMethod())
                .path(entity.getPath())
                .description(entity.getDescription())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}