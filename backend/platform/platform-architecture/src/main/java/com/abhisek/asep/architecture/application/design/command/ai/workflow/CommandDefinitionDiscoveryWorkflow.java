package com.abhisek.asep.architecture.application.design.command.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.command.ai.context.CommandPromptContextFactory;
import com.abhisek.asep.architecture.application.design.command.ai.dto.CommandDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.command.ai.parser.CommandDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.command.ai.prompt.CommandDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandDefinitionDiscoveryWorkflow {

    private final CommandPromptContextFactory contextFactory;

    private final CommandDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final CommandDefinitionDiscoveryResponseParser parser;

    public CommandDefinitionDiscoveryResponse execute(
            String aggregateModel) {

        PromptContext context =
                contextFactory.create(aggregateModel);

        AIRequest request =
                promptBuilder.build(context);

        AIResponse response =
                aiService.generate(request);

        return parser.parse(response);

    }

}