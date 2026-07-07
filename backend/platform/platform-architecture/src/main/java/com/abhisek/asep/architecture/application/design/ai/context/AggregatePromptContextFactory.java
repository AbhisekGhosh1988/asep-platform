package com.abhisek.asep.architecture.application.design.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.ai.prompt.AggregatePromptVariables;
import org.springframework.stereotype.Component;

@Component
public class AggregatePromptContextFactory implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String architecture) {

        return PromptContext.builder().build().put(AggregatePromptVariables.ARCHITECTURE, architecture);

    }

}