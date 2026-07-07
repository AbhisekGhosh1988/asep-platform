package com.abhisek.asep.architecture.application.design.domainevent.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class DomainEventDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate and Domain Services.
                
                Discover Domain Events.
                
                Rules
                
                1. Events represent completed business actions.
                2. Event names must end with Event.
                3. Ignore CRUD events.
                4. Ignore technical events.
                5. Return JSON only.
                6. No markdown.
                
                Return
                
                {
                  "domainEvents":[
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

        userPrompt = PromptUtils.replace(userPrompt, DomainEventPromptVariables.AGGREGATE, context.get(DomainEventPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}