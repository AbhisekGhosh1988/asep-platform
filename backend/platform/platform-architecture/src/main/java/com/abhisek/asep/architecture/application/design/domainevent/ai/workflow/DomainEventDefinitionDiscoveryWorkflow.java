package com.abhisek.asep.architecture.application.design.domainevent.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.domainevent.ai.context.DomainEventPromptContextFactory;
import com.abhisek.asep.architecture.application.design.domainevent.ai.dto.DomainEventDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainevent.ai.parser.DomainEventDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.domainevent.ai.prompt.DomainEventDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainEventDefinitionDiscoveryWorkflow {

    private final DomainEventPromptContextFactory contextFactory;

    private final DomainEventDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final DomainEventDefinitionDiscoveryResponseParser parser;

    public DomainEventDefinitionDiscoveryResponse execute(
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