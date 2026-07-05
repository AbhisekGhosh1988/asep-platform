package com.abhisek.asep.ai.prompt.builder;

import com.abhisek.asep.ai.core.config.AIModel;
import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;

public abstract class AbstractPromptBuilder implements BasePromptBuilder {

    @Override
    public AIRequest build(PromptContext context) {

        PromptTemplate template = createTemplate(context);

        return AIRequest.builder().model(getModel()).systemPrompt(template.getSystemPrompt()).userPrompt(template.getUserPrompt()).build();

    }

    protected AIModel getModel() {

        return AIModel.LLAMA3_1;

    }

    protected abstract PromptTemplate createTemplate(PromptContext context);

}