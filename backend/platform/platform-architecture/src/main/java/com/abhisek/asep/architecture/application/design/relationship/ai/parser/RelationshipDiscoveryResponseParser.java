package com.abhisek.asep.architecture.application.design.relationship.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.relationship.ai.dto.RelationshipDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RelationshipDiscoveryResponseParser
        extends AbstractJsonResponseParser<RelationshipDiscoveryResponse> {

    public RelationshipDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<RelationshipDiscoveryResponse> targetType() {

        return RelationshipDiscoveryResponse.class;

    }

}