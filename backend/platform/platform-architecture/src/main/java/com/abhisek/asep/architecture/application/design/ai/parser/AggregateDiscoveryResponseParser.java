package com.abhisek.asep.architecture.application.design.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.ai.dto.AggregateDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class AggregateDiscoveryResponseParser extends AbstractJsonResponseParser<AggregateDiscoveryResponse> {

    public AggregateDiscoveryResponseParser(ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<AggregateDiscoveryResponse> targetType() {

        return AggregateDiscoveryResponse.class;

    }

}