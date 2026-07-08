package com.abhisek.asep.architecture.application.design.factory.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.factory.query.dto.FactoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.factory.query.mapper.FactoryDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import org.springframework.stereotype.Component;

@Component
public class FactoryDefinitionQueryMapperImpl
        implements FactoryDefinitionQueryMapper {

    @Override
    public FactoryDefinitionDetailsResponse toResponse(
            FactoryDefinition factoryDefinition) {

        if (factoryDefinition == null) {
            return null;
        }

        return FactoryDefinitionDetailsResponse.builder()
                .id(factoryDefinition.getId())
                .aggregateId(factoryDefinition.getAggregateId())
                .name(factoryDefinition.getName())
                .description(factoryDefinition.getDescription())
                .build();

    }

}