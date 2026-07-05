package com.abhisek.asep.ai.prompt.builder;

import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.constants.AIConstants;
import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.prompt.PromptBuilder;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;

public abstract class AbstractPromptBuilder<T>
        implements PromptBuilder<T> {

    @Override
    public AIRequest build(T input) {

        PromptTemplate template =
                createPrompt(input);

        return AIRequest.builder()
                .model(getModel())
                .systemPrompt(template.getSystemPrompt())
                .userPrompt(template.getUserPrompt())
                .temperature(getTemperature())
                .maxTokens(getMaxTokens())
                .build();

    }

    /**
     * Child classes generate the prompt.
     */
    protected abstract PromptTemplate createPrompt(T input);

    /**
     * Override if another model is required.
     */
    protected AIModel getModel() {

        return AIModel.LLAMA3_1;

    }

    /**
     * Override if another temperature is required.
     */
    protected Double getTemperature() {

        return AIConstants.DEFAULT_TEMPERATURE;

    }

    /**
     * Override if another max token limit is required.
     */
    protected Integer getMaxTokens() {

        return AIConstants.DEFAULT_MAX_TOKENS;

    }

}