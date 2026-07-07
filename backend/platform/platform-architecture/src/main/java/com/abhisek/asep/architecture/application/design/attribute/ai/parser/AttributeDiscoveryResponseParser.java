package com.abhisek.asep.architecture.application.design.attribute.ai.parser;


import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.attribute.ai.dto.AttributeDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class AttributeDiscoveryResponseParser
        extends AbstractJsonResponseParser<AttributeDiscoveryResponse> {

    public AttributeDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<AttributeDiscoveryResponse> targetType() {

        return AttributeDiscoveryResponse.class;

    }

}