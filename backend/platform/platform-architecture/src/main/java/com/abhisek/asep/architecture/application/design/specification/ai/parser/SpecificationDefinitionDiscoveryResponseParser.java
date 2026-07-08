package com.abhisek.asep.architecture.application.design.specification.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.specification.ai.dto.SpecificationDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class SpecificationDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<SpecificationDefinitionDiscoveryResponse> {

    public SpecificationDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<SpecificationDefinitionDiscoveryResponse> targetType() {

        return SpecificationDefinitionDiscoveryResponse.class;

    }

}