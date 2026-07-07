package com.abhisek.asep.architecture.application.design.attribute.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.attribute.ai.prompt.AttributePromptVariables;
import org.springframework.stereotype.Component;

@Component
public class AttributePromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String entity) {

        return PromptContext.builder()
                .build()
                .put(
                        AttributePromptVariables.ENTITY,
                        entity);

    }

}