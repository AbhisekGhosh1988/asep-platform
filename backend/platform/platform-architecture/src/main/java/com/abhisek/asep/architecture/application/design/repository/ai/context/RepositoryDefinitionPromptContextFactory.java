package com.abhisek.asep.architecture.application.design.repository.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.repository.ai.prompt.RepositoryDefinitionPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        RepositoryDefinitionPromptVariables.AGGREGATE,
                        aggregate);

    }

}