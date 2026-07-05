package com.abhisek.asep.ai.core.client;

import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;

import java.util.Set;

public interface AIProvider {

    /**
     * Provider name.
     *
     * Example:
     * OLLAMA
     * OPENAI
     * AZURE_OPENAI
     */
    String getProviderName();

    /**
     * Checks whether the provider is available.
     */
    boolean isAvailable();

    /**
     * Returns supported model.
     */

    Set<AIModel> getSupportedModels();

    /**
     * Generates AI response.
     */
    AIResponse generate(AIRequest request);

}