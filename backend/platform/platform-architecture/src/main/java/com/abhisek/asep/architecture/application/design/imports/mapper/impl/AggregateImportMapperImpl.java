package com.abhisek.asep.architecture.application.design.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.imports.dto.request.AggregateImportRequest;
import com.abhisek.asep.architecture.application.design.imports.mapper.AggregateImportMapper;
import com.abhisek.asep.architecture.domain.model.Aggregate;
import org.springframework.stereotype.Component;

@Component
public class AggregateImportMapperImpl implements AggregateImportMapper {

    @Override
    public Aggregate toAggregate(AggregateImportRequest request) {

        return Aggregate.builder().microserviceId(request.getMicroserviceId()).name(request.getName()).description(request.getDescription()).build();

    }

}