package com.abhisek.asep.architecture.application.design.attribute.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class AttributeDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Domain Driven Design Architect.
                
                Analyse the Entity and identify its Domain Attributes.
                
                Rules
                
                1. Return only business attributes.
                2. Do NOT generate relationships.
                3. Do NOT generate collections.
                4. Do NOT generate audit fields.
                5. Use only supported data types:
                
                   String
                   Integer
                   Long
                   Double
                   BigDecimal
                   Boolean
                   UUID
                   LocalDate
                   LocalDateTime
                   Instant
                   Enum
                
                6. Return valid JSON only.
                7. Do not use markdown.
                
                Return exactly:
                
                {
                  "attributes":[
                    {
                      "name":"",
                      "dataType":"",
                      "required":true,
                      "nullable":false,
                      "unique":false,
                      "description":""
                    }
                  ]
                }
                """;

        String userPrompt = """
                Entity
                
                {{entity}}
                """;

        userPrompt = PromptUtils.replace(userPrompt, AttributePromptVariables.ENTITY, context.get(AttributePromptVariables.ENTITY));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}