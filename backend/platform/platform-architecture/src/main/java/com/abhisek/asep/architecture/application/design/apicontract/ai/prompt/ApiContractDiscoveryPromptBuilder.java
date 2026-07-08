package com.abhisek.asep.architecture.application.design.apicontract.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class ApiContractDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Enterprise API Architect.
                
                Analyse the complete Domain Model.
                
                Discover REST API Contracts.
                
                Rules
                
                1. Follow REST principles.
                2. Use resource-based URIs.
                3. Choose correct HTTP methods.
                4. Generate CRUD only when appropriate.
                5. Generate business operations from Domain Services.
                6. Return JSON only.
                7. No markdown.
                
                Return
                
                {
                  "apiContracts":[
                    {
                      "name":"",
                      "method":"",
                      "path":"",
                      "description":""
                    }
                  ]
                }
                """;

        String userPrompt = """
                Aggregate
                
                {{aggregate}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, ApiContractPromptVariables.AGGREGATE, context.get(ApiContractPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}