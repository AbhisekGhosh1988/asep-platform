package com.abhisek.asep.architecture.application.design.valueobject.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.valueobject.ai.prompt.ValueObjectPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectPromptContextFactory implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder().build().put(ValueObjectPromptVariables.AGGREGATE, aggregate);

    }

}