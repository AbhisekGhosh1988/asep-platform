package com.abhisek.asep.architecture.application.design.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.mapper.AggregateQueryMapper;
import com.abhisek.asep.architecture.domain.model.Aggregate;
import org.springframework.stereotype.Component;

@Component
public class AggregateQueryMapperImpl
        implements AggregateQueryMapper {

    @Override
    public AggregateDetailsResponse toResponse(
            Aggregate aggregate) {

        if (aggregate == null) {
            return null;
        }

        return AggregateDetailsResponse.builder()
                .id(aggregate.getId())
                .microserviceId(aggregate.getMicroserviceId())
                .name(aggregate.getName())
                .description(aggregate.getDescription())
                .build();

    }

}