package com.abhisek.asep.architecture.application.design.query.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.query.ai.dto.QueryDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class QueryDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<QueryDefinitionDiscoveryResponse> {

    public QueryDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<QueryDefinitionDiscoveryResponse> targetType() {

        return QueryDefinitionDiscoveryResponse.class;

    }

}