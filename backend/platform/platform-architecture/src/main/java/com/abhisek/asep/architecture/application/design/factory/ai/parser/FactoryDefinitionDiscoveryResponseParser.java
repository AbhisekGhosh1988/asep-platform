package com.abhisek.asep.architecture.application.design.factory.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.factory.ai.dto.FactoryDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class FactoryDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<FactoryDefinitionDiscoveryResponse> {

    public FactoryDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<FactoryDefinitionDiscoveryResponse> targetType() {

        return FactoryDefinitionDiscoveryResponse.class;

    }

}