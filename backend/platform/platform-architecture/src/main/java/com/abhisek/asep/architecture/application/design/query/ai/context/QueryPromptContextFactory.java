package com.abhisek.asep.architecture.application.design.query.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.query.ai.prompt.QueryPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class QueryPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        QueryPromptVariables.AGGREGATE,
                        aggregate);

    }

}