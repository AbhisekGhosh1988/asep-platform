package com.abhisek.asep.architecture.application.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class ArchitectureDiscoveryPromptBuilder
        extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Enterprise Solution Architect.

                Your responsibility is to analyse the given software requirements
                and identify the architecture.

                Identify:

                1. Bounded Contexts
                2. Microservices
                3. Responsibilities
                4. Suggested Architecture Style

                IMPORTANT

                Return ONLY valid JSON.

                Do NOT return markdown.

                Do NOT use ```json.

                Do NOT explain anything.

                Architecture Style must be one of:

                LAYERED
                HEXAGONAL
                CLEAN_ARCHITECTURE
                MICROSERVICE
                EVENT_DRIVEN
                MODULAR_MONOLITH

                Return ONLY JSON.
                """;

        String userPrompt = """
                Software Requirements

                {{requirements}}

                Return JSON in the following format.

                {
                  "boundedContexts":[
                    {
                      "name":"",
                      "description":"",
                      "responsibility":"",
                      "microservices":[
                        {
                          "name":"",
                          "description":"",
                          "style":"MICROSERVICE"
                        }
                      ]
                    }
                  ]
                }
                """;

        userPrompt = PromptUtils.replace(
                userPrompt,
                ArchitecturePromptVariables.REQUIREMENTS,
                context.get(ArchitecturePromptVariables.REQUIREMENTS));

        return PromptTemplate.builder()
                .systemPrompt(systemPrompt)
                .userPrompt(userPrompt)
                .build();

    }

}