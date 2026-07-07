package com.abhisek.asep.architecture.application.design.domainservice.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class DomainServiceDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the complete Aggregate.
                
                Discover Domain Services.
                
                A Domain Service represents business behaviour
                that does not naturally belong to a single Entity
                or Value Object.
                
                Rules
                
                1. Discover only business services.
                2. Ignore CRUD operations.
                3. Ignore Repository operations.
                4. Ignore technical services.
                5. Service names must end with Service.
                6. Return JSON only.
                7. No markdown.
                
                Return
                
                {
                  "domainServices":[
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

        userPrompt = PromptUtils.replace(userPrompt, DomainServicePromptVariables.AGGREGATE, context.get(DomainServicePromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}