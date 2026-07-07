package com.abhisek.asep.architecture.application.design.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class AggregateDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the architecture and identify the Aggregate Roots.
                
                Rules:
                
                1. Follow Domain Driven Design.
                2. Return ONLY Aggregate Roots.
                3. Do not return Entities.
                4. Do not return Value Objects.
                5. Return ONLY valid JSON.
                6. Do not use markdown.
                
                Return JSON exactly as:
                
                {
                  "aggregates":[
                    {
                      "name":"",
                      "description":""
                    }
                  ]
                }
                """;

        String userPrompt = """
                Architecture
                
                {{architecture}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, AggregatePromptVariables.ARCHITECTURE, context.get(AggregatePromptVariables.ARCHITECTURE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}