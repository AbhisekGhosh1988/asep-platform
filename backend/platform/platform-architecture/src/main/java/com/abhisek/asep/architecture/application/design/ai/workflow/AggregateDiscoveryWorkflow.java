package com.abhisek.asep.architecture.application.design.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.ai.context.AggregatePromptContextFactory;
import com.abhisek.asep.architecture.application.design.ai.dto.AggregateDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.ai.parser.AggregateDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.ai.prompt.AggregateDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AggregateDiscoveryWorkflow {

    private final AggregatePromptContextFactory contextFactory;

    private final AggregateDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final AggregateDiscoveryResponseParser parser;

    public AggregateDiscoveryResponse execute(String architecture) {

        PromptContext context = contextFactory.create(architecture);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}