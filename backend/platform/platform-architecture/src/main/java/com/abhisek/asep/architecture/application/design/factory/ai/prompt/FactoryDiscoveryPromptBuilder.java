package com.abhisek.asep.architecture.application.design.factory.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class FactoryDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate.
                
                Discover Domain Factories.
                
                Rules
                
                1. Generate only when required.
                2. One factory per aggregate.
                3. Factory names must end with Factory.
                4. Ignore CRUD.
                5. Return JSON only.
                6. No markdown.
                
                Return
                
                {
                  "factories":[
                    {
                      "name":"",
                      "description":""
                    }
                  ]
                }
                """;

        String userPrompt = """
                Aggregate
                
                {{aggregate}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, FactoryPromptVariables.AGGREGATE, context.get(FactoryPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}