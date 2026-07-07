package com.abhisek.asep.architecture.application.design.repository.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.repository.ai.context.RepositoryDefinitionPromptContextFactory;
import com.abhisek.asep.architecture.application.design.repository.ai.dto.RepositoryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.repository.ai.parser.RepositoryDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.repository.ai.prompt.RepositoryDefinitionDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryDefinitionDiscoveryWorkflow {

    private final RepositoryDefinitionPromptContextFactory contextFactory;

    private final RepositoryDefinitionDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final RepositoryDefinitionDiscoveryResponseParser parser;

    public RepositoryDefinitionDiscoveryResponse execute(
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