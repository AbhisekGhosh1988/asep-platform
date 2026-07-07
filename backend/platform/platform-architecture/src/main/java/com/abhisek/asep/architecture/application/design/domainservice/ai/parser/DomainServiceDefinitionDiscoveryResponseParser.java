package com.abhisek.asep.architecture.application.design.domainservice.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.domainservice.ai.dto.DomainServiceDefinitionDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class DomainServiceDefinitionDiscoveryResponseParser
        extends AbstractJsonResponseParser<DomainServiceDefinitionDiscoveryResponse> {

    public DomainServiceDefinitionDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<DomainServiceDefinitionDiscoveryResponse> targetType() {

        return DomainServiceDefinitionDiscoveryResponse.class;

    }

}