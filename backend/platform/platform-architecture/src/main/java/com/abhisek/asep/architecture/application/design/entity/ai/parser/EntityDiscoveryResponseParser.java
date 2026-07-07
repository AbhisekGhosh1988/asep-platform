package com.abhisek.asep.architecture.application.design.entity.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.entity.ai.dto.EntityDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDiscoveryResponseParser
        extends AbstractJsonResponseParser<EntityDiscoveryResponse> {

    public EntityDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<EntityDiscoveryResponse> targetType() {

        return EntityDiscoveryResponse.class;

    }

}