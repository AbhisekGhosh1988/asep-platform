package com.abhisek.asep.ai.parser.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ResponseParserSupport {

    protected final ObjectMapper objectMapper;

    protected <T> T readValue(String json,
                              Class<T> type) throws Exception {

        return objectMapper.readValue(json, type);

    }

}