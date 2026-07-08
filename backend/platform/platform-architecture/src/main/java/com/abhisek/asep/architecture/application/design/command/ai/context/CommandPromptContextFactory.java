package com.abhisek.asep.architecture.application.design.command.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.command.ai.prompt.CommandPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class CommandPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        CommandPromptVariables.AGGREGATE,
                        aggregate);

    }

}