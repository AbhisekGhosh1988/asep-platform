package com.abhisek.asep.architecture.application.design.domainservice.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.domainservice.ai.prompt.DomainServicePromptVariables;
import org.springframework.stereotype.Component;

@Component
public class DomainServicePromptContextFactory implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder().build().put(DomainServicePromptVariables.AGGREGATE, aggregate);

    }

}