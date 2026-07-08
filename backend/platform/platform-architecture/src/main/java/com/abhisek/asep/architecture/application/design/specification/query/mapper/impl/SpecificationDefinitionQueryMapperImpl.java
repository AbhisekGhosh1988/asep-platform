package com.abhisek.asep.architecture.application.design.specification.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.specification.query.dto.SpecificationDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.specification.query.mapper.SpecificationDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import org.springframework.stereotype.Component;

@Component
public class SpecificationDefinitionQueryMapperImpl
        implements SpecificationDefinitionQueryMapper {

    @Override
    public SpecificationDefinitionDetailsResponse toResponse(
            SpecificationDefinition specification) {

        if (specification == null) {
            return null;
        }

        return SpecificationDefinitionDetailsResponse.builder()
                .id(specification.getId())
                .aggregateId(specification.getAggregateId())
                .name(specification.getName())
                .description(specification.getDescription())
                .build();

    }

}