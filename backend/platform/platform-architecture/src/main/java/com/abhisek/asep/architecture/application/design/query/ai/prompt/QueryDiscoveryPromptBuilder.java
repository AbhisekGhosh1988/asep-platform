package com.abhisek.asep.architecture.application.design.query.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class QueryDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior CQRS Architect.
                
                Analyse the Aggregate.
                
                Discover read Queries.
                
                Rules
                
                1. Queries represent business reads.
                2. Ignore CRUD queries if unnecessary.
                3. One query per business use case.
                4. Query names must end with Query.
                5. Return JSON only.
                6. No markdown.
                
                Return
                
                {
                  "queries":[
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

        userPrompt = PromptUtils.replace(userPrompt, QueryPromptVariables.AGGREGATE, context.get(QueryPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}