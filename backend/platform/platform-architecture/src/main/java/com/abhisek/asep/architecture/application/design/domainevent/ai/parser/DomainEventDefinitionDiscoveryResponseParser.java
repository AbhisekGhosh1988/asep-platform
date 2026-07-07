package com.abhisek.asep.architecture.application.design.domainevent.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.domainevent.ai.dto.DomainEventDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class DomainEventDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<DomainEventDefinitionDiscoveryResponse> {

    public DomainEventDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<DomainEventDefinitionDiscoveryResponse> targetType() {

        return DomainEventDefinitionDiscoveryResponse.class;

    }

}