package com.abhisek.asep.architecture.application.design.valueobject.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate.
                
                Identify Value Objects.
                
                Rules
                
                1. Only discover immutable concepts.
                2. Never return Entities.
                3. Never return Aggregates.
                4. Never return Services.
                5. Never return Events.
                6. Return JSON only.
                7. No markdown.
                
                Return
                
                {
                  "valueObjects":[
                    {
                      "name":"",
                      "description":"",
                      "immutable":true
                    }
                  ]
                }
                """;

        String userPrompt = """
                Aggregate
                
                {{aggregate}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, ValueObjectPromptVariables.AGGREGATE, context.get(ValueObjectPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}