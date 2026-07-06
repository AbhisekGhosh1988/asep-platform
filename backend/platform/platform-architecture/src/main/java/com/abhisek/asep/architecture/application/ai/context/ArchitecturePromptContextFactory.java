package com.abhisek.asep.architecture.application.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.ai.prompt.ArchitecturePromptVariables;
import org.springframework.stereotype.Component;

@Component
public class ArchitecturePromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String requirements) {

        return PromptContext.builder()
                .build()
                .put(
                        ArchitecturePromptVariables.REQUIREMENTS,
                        requirements);

    }

}