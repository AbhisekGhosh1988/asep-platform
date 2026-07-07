package com.abhisek.asep.architecture.application.design.valueobject.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.valueobject.ai.context.ValueObjectPromptContextFactory;
import com.abhisek.asep.architecture.application.design.valueobject.ai.dto.ValueObjectDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.valueobject.ai.parser.ValueObjectDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.valueobject.ai.prompt.ValueObjectDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValueObjectDiscoveryWorkflow {

    private final ValueObjectPromptContextFactory contextFactory;

    private final ValueObjectDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final ValueObjectDiscoveryResponseParser parser;

    public ValueObjectDiscoveryResponse execute(String aggregateModel) {

        PromptContext context = contextFactory.create(aggregateModel);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}