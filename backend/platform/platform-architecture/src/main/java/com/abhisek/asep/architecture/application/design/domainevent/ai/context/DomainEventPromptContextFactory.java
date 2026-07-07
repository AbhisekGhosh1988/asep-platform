package com.abhisek.asep.architecture.application.design.domainevent.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.domainevent.ai.prompt.DomainEventPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class DomainEventPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        DomainEventPromptVariables.AGGREGATE,
                        aggregate);

    }

}