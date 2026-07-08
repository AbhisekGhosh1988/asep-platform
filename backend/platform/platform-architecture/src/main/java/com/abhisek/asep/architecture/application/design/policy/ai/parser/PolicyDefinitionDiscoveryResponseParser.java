package com.abhisek.asep.architecture.application.design.policy.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.policy.ai.dto.PolicyDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class PolicyDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<PolicyDefinitionDiscoveryResponse> {

    public PolicyDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<PolicyDefinitionDiscoveryResponse> targetType() {

        return PolicyDefinitionDiscoveryResponse.class;

    }

}