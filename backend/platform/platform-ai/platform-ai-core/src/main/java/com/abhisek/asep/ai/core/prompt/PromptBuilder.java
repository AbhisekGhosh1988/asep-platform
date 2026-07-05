package com.abhisek.asep.ai.core.prompt;

import com.abhisek.asep.ai.core.model.request.AIRequest;

public interface PromptBuilder<T> {

    /**
     * Builds an AI request from the supplied input.
     *
     * @param input business input
     * @return AIRequest
     */
    AIRequest build(T input);

}