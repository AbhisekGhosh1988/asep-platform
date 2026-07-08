package com.abhisek.asep.architecture.application.design.policy.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.policy.query.dto.PolicyDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.policy.query.mapper.PolicyDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import org.springframework.stereotype.Component;

@Component
public class PolicyDefinitionQueryMapperImpl
        implements PolicyDefinitionQueryMapper {

    @Override
    public PolicyDefinitionDetailsResponse toResponse(
            PolicyDefinition policy) {

        if (policy == null) {
            return null;
        }

        return PolicyDefinitionDetailsResponse.builder()
                .id(policy.getId())
                .aggregateId(policy.getAggregateId())
                .name(policy.getName())
                .description(policy.getDescription())
                .build();
    }
}