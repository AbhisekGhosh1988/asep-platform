package com.abhisek.asep.architecture.application.design.apicontract.ai.parser;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.architecture.application.design.apicontract.ai.dto.ApiContractDiscoveryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ApiContractDiscoveryResponseParser
        extends AbstractJsonResponseParser<ApiContractDiscoveryResponse> {

    public ApiContractDiscoveryResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    @Override
    protected Class<ApiContractDiscoveryResponse> targetType() {

        return ApiContractDiscoveryResponse.class;

    }

}