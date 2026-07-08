package com.abhisek.asep.architecture.application.design.policy.query.mapper;

import com.abhisek.asep.architecture.application.design.policy.query.dto.PolicyDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.PolicyDefinition;

public interface PolicyDefinitionQueryMapper {

    PolicyDefinitionDetailsResponse toResponse(
            PolicyDefinition policy);

}