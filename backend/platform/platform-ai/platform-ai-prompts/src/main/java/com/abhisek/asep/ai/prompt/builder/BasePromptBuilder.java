package com.abhisek.asep.ai.prompt.builder;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.prompt.context.PromptContext;

public interface BasePromptBuilder {

    AIRequest build(
            PromptContext context);

}