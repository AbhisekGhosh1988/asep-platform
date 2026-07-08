package com.abhisek.asep.architecture.application.design.specification.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.specification.ai.prompt.SpecificationPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class SpecificationPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        SpecificationPromptVariables.AGGREGATE,
                        aggregate);

    }

}