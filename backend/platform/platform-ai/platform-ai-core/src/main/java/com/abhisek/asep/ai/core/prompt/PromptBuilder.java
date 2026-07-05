package com.abhisek.asep.ai.core.prompt;

import com.abhisek.asep.ai.core.model.request.AIRequest;

public interface PromptBuilder<T> {

    /**
     * Builds AI request.
     */
    AIRequest build(T input);

}