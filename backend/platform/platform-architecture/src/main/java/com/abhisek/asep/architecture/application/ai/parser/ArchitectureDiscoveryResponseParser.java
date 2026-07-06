package com.abhisek.asep.architecture.application.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.ai.dto.ArchitectureDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ArchitectureDiscoveryResponseParser
        extends AbstractJsonResponseParser<ArchitectureDiscoveryResponse> {

    public ArchitectureDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<ArchitectureDiscoveryResponse> targetType() {

        return ArchitectureDiscoveryResponse.class;

    }

}