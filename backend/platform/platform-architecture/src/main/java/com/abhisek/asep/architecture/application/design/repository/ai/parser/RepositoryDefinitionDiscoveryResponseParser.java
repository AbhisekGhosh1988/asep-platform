package com.abhisek.asep.architecture.application.design.repository.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.repository.ai.dto.RepositoryDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<RepositoryDefinitionDiscoveryResponse> {

    public RepositoryDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<RepositoryDefinitionDiscoveryResponse> targetType() {

        return RepositoryDefinitionDiscoveryResponse.class;

    }

}