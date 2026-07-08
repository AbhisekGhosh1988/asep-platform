package com.abhisek.asep.architecture.application.design.policy.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.policy.ai.prompt.PolicyPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class PolicyPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        PolicyPromptVariables.AGGREGATE,
                        aggregate);

    }

}