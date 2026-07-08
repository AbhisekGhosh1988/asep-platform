package com.abhisek.asep.architecture.application.design.command.ai.prompt;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandDiscoveryPromptBuilder extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior CQRS Architect.
                
                Analyse the Aggregate.
                
                Discover write Commands.
                
                Rules
                
                1. Commands represent business intent.
                2. Ignore CRUD if unnecessary.
                3. One command per business action.
                4. Command names must end with Command.
                5. Return JSON only.
                6. No markdown.
                
                Return
                
                {
                  "commands":[
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

        userPrompt = PromptUtils.replace(userPrompt, CommandPromptVariables.AGGREGATE, context.get(CommandPromptVariables.AGGREGATE));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();

    }

}