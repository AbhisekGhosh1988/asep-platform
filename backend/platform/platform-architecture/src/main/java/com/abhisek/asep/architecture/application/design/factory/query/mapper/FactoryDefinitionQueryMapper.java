package com.abhisek.asep.architecture.application.design.factory.query.mapper;

import com.abhisek.asep.architecture.application.design.factory.query.dto.FactoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.FactoryDefinition;

public interface FactoryDefinitionQueryMapper {

    FactoryDefinitionDetailsResponse toResponse(
            FactoryDefinition factoryDefinition);

}