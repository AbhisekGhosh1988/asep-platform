package com.abhisek.asep.architecture.application.design.command.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.command.ai.dto.CommandDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CommandDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<CommandDefinitionDiscoveryResponse> {

    public CommandDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<CommandDefinitionDiscoveryResponse> targetType() {

        return CommandDefinitionDiscoveryResponse.class;

    }

}