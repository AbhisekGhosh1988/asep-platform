package com.abhisek.asep.architecture.application.design.policy.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.policy.imports.dto.request.PolicyDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.policy.imports.mapper.PolicyDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import org.springframework.stereotype.Component;

@Component
public class PolicyDefinitionImportMapperImpl
        implements PolicyDefinitionImportMapper {

    @Override
    public PolicyDefinition toPolicy(
            PolicyDefinitionImportRequest request) {

        if (request == null) {
            return null;
        }

        return PolicyDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}