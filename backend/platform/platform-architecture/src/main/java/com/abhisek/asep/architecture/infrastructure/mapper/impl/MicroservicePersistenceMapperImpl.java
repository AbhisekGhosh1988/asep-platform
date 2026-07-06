package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Microservice;
import com.abhisek.asep.architecture.infrastructure.mapper.MicroservicePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.MicroserviceEntity;
import org.springframework.stereotype.Component;

@Component
public class MicroservicePersistenceMapperImpl
        implements MicroservicePersistenceMapper {

    @Override
    public MicroserviceEntity toEntity(Microservice microservice) {

        if (microservice == null) {
            return null;
        }

        return MicroserviceEntity.builder()
                .id(microservice.getId())
                .boundedContextId(microservice.getBoundedContextId())
                .name(microservice.getName())
                .description(microservice.getDescription())
                .style(microservice.getStyle())
                .createdBy(microservice.getCreatedBy())
                .createdAt(microservice.getCreatedAt())
                .updatedBy(microservice.getUpdatedBy())
                .updatedAt(microservice.getUpdatedAt())
                .build();

    }

    @Override
    public Microservice toDomain(MicroserviceEntity entity) {

        if (entity == null) {
            return null;
        }

        return Microservice.builder()
                .id(entity.getId())
                .boundedContextId(entity.getBoundedContextId())
                .name(entity.getName())
                .description(entity.getDescription())
                .style(entity.getStyle())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}