package com.abhisek.asep.architecture.application.design.factory.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.factory.ai.prompt.FactoryPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class FactoryPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        FactoryPromptVariables.AGGREGATE,
                        aggregate);

    }

}