package com.abhisek.asep.architecture.application.design.specification.imports.mapper;

import com.abhisek.asep.architecture.application.design.specification.imports.dto.request.SpecificationDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;

public interface SpecificationDefinitionImportMapper {

    SpecificationDefinition toSpecification(
            SpecificationDefinitionImportRequest request);

}