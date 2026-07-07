package com.abhisek.asep.architecture.application.design.relationship.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class RelationshipDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Aggregate Model.
                
                Infer relationships between entities.
                
                Rules
                
                1. Return ONLY relationships between Entities.
                2. Do NOT create relationships to Value Objects.
                3. Do NOT create duplicate relationships.
                4. Infer cardinality.
                5. Infer cascade strategy.
                6. Infer fetch strategy.
                7. Infer mappedBy.
                8. Return valid JSON only.
                9. No markdown.
                
                RelationshipType values:
                
                ONE_TO_ONE
                ONE_TO_MANY
                MANY_TO_ONE
                MANY_TO_MANY
                
                CascadeType values:
                
                ALL
                PERSIST
                MERGE
                REMOVE
                REFRESH
                DETACH
                
                FetchType values:
                
                LAZY
                EAGER
                
                Return exactly
                
                {
                  "relationships":[
                    {
                      "sourceEntity":"",
                      "targetEntity":"",
                      "relationshipType":"",
                      "fieldName":"",
                      "mappedBy":"",
                      "cascadeType":"",
                      "fetchType":"",
                      "optional":false,
                      "orphanRemoval":false,
                      "description":""
                    }
                  ]
                }
                """;

        String userPrompt = """
                Aggregate Model
                
                {{aggregate}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, RelationshipPromptVariables.AGGREGATE, context.get(RelationshipPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}