package com.abhisek.asep.architecture.application.design.policy.imports.mapper;

import com.abhisek.asep.architecture.application.design.policy.imports.dto.request.PolicyDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.PolicyDefinition;

public interface PolicyDefinitionImportMapper {

    PolicyDefinition toPolicy(
            PolicyDefinitionImportRequest request);

}