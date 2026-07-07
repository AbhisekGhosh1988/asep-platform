package com.abhisek.asep.architecture.application.design.attribute.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.attribute.ai.context.AttributePromptContextFactory;
import com.abhisek.asep.architecture.application.design.attribute.ai.dto.AttributeDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.attribute.ai.parser.AttributeDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.attribute.ai.prompt.AttributeDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeDiscoveryWorkflow {

    private final AttributePromptContextFactory contextFactory;

    private final AttributeDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final AttributeDiscoveryResponseParser parser;

    public AttributeDiscoveryResponse execute(String entity) {

        PromptContext context = contextFactory.create(entity);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}