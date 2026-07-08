package com.abhisek.asep.architecture.application.design.factory.imports.mapper;

import com.abhisek.asep.architecture.application.design.factory.imports.dto.request.FactoryDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.FactoryDefinition;

public interface FactoryDefinitionImportMapper {

    FactoryDefinition toFactory(
            FactoryDefinitionImportRequest request);

}