package com.abhisek.asep.ai.core.parser;

import com.abhisek.asep.ai.core.model.response.AIResponse;

public interface ResponseParser<T> {

    /**
     * Parse AI response into domain object.
     */
    T parse(AIResponse response);

}