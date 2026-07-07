package com.abhisek.asep.architecture.application.design.entity.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate and identify ONLY Domain Entities.
                
                Rules
                
                1. Do not return Aggregate Roots.
                2. Do not return Value Objects.
                3. Do not return Repositories.
                4. Do not return Services.
                5. Return ONLY valid JSON.
                6. No markdown.
                
                Return JSON exactly as
                
                {
                  "entities":[
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

        userPrompt = PromptUtils.replace(userPrompt, EntityPromptVariables.AGGREGATE, context.get(EntityPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}