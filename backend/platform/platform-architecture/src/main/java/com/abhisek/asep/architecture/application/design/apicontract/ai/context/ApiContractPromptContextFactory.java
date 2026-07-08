package com.abhisek.asep.architecture.application.design.apicontract.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.apicontract.ai.prompt.ApiContractPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class ApiContractPromptContextFactory
        implements PromptContextFactory<String> {

    @Override
    public PromptContext create(
            String aggregate) {

        return PromptContext.builder()
                .build()
                .put(
                        ApiContractPromptVariables.AGGREGATE,
                        aggregate);

    }

}