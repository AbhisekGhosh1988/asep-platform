package com.abhisek.asep.architecture.application.design.repository.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate.
                
                Discover repository interfaces.
                
                Rules
                
                1. One repository per Aggregate Root.
                2. Repository names must end with Repository.
                3. Never generate Entity repositories.
                4. Return JSON only.
                5. No markdown.
                
                Return
                
                {
                  "repositories":[
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

        userPrompt = PromptUtils.replace(userPrompt, RepositoryDefinitionPromptVariables.AGGREGATE, context.get(RepositoryDefinitionPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}