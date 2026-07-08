package com.abhisek.asep.architecture.application.design.factory.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.factory.ai.context.FactoryPromptContextFactory;
import com.abhisek.asep.architecture.application.design.factory.ai.dto.FactoryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.factory.ai.parser.FactoryDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.factory.ai.prompt.FactoryDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactoryDefinitionDiscoveryWorkflow {

    private final FactoryPromptContextFactory contextFactory;

    private final FactoryDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final FactoryDefinitionDiscoveryResponseParser parser;

    public FactoryDefinitionDiscoveryResponse execute(
            String aggregateModel) {

        PromptContext context =
                contextFactory.create(
                        aggregateModel);

        AIRequest request =
                promptBuilder.build(context);

        AIResponse response =
                aiService.generate(request);

        return parser.parse(response);

    }

}