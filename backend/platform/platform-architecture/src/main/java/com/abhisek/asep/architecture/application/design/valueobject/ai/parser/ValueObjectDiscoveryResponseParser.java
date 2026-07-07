package com.abhisek.asep.architecture.application.design.valueobject.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.valueobject.ai.dto.ValueObjectDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectDiscoveryResponseParser extends AbstractJsonResponseParser<ValueObjectDiscoveryResponse> {

    public ValueObjectDiscoveryResponseParser(ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<ValueObjectDiscoveryResponse> targetType() {

        return ValueObjectDiscoveryResponse.class;

    }

}