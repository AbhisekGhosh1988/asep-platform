package com.abhisek.asep.architecture.application.design.specification.query.mapper;

import com.abhisek.asep.architecture.application.design.specification.query.dto.SpecificationDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;

public interface SpecificationDefinitionQueryMapper {

    SpecificationDefinitionDetailsResponse toResponse(
            SpecificationDefinition specification);

}