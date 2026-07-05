package com.abhisek.asep.ai.parser.base;

import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.parser.ResponseParser;
import com.abhisek.asep.ai.parser.exception.ParserException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractJsonResponseParser<T>
        extends ResponseParserSupport
        implements ResponseParser<T> {

    protected AbstractJsonResponseParser(
            ObjectMapper objectMapper) {

        super(objectMapper);

    }

    protected abstract Class<T> targetType();

    @Override
    public T parse(AIResponse response) {

        try {

            return readValue(
                    response.getContent(),
                    targetType());

        }

        catch (Exception ex) {

            throw new ParserException(
                    "Failed to parse AI response.",
                    ex);

        }

    }

}