package com.abhisek.asep.architecture.application.design.entity.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.entity.imports.dto.request.EntityImportRequest;
import com.abhisek.asep.architecture.application.design.entity.imports.mapper.EntityImportMapper;
import com.abhisek.asep.architecture.domain.model.Entity;
import org.springframework.stereotype.Component;

@Component
public class EntityImportMapperImpl
        implements EntityImportMapper {

    @Override
    public Entity toEntity(
            EntityImportRequest request) {

        return Entity.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .rootEntity(request.getRootEntity())
                .build();

    }

}