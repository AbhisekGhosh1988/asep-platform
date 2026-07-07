package com.abhisek.asep.architecture.application.design.entity.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.entity.ai.prompt.EntityPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class EntityPromptContextFactory implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder().build().put(EntityPromptVariables.AGGREGATE, aggregate);

    }

}