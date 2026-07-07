package com.abhisek.asep.architecture.application.design.entity.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.mapper.EntityQueryMapper;
import com.abhisek.asep.architecture.domain.model.Entity;
import org.springframework.stereotype.Component;

@Component
public class EntityQueryMapperImpl
        implements EntityQueryMapper {

    @Override
    public EntityDetailsResponse toResponse(Entity entity) {

        if (entity == null) {
            return null;
        }

        return EntityDetailsResponse.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .rootEntity(entity.getRootEntity())
                .build();

    }

}