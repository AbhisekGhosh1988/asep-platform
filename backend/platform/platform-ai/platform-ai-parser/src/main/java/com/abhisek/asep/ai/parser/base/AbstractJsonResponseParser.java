package com.abhisek.asep.ai.parser.base;

import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.parser.ResponseParser;
import com.abhisek.asep.ai.parser.exception.ParserException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractJsonResponseParser<T> extends ResponseParserSupport implements ResponseParser<T> {

    protected AbstractJsonResponseParser(ObjectMapper objectMapper) {

        super(objectMapper);

    }

    protected abstract Class<T> targetType();

    @Override
    public T parse(AIResponse response) {

        try {

            log.info("========== AI RAW RESPONSE ==========");
            log.info(response.getContent());
            log.info("=====================================");

            return readValue(response.getContent(), targetType());

        } catch (Exception ex) {

            log.error("Failed to parse AI response");
            log.error("Raw AI Response:\n{}", response.getContent(), ex);

            throw new ParserException("Failed to parse AI response.", ex);

        }

    }

}