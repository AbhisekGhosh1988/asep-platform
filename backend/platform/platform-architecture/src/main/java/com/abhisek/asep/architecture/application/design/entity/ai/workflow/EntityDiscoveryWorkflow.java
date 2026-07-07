package com.abhisek.asep.architecture.application.design.entity.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.entity.ai.context.EntityPromptContextFactory;
import com.abhisek.asep.architecture.application.design.entity.ai.dto.EntityDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.entity.ai.parser.EntityDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.entity.ai.prompt.EntityDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityDiscoveryWorkflow {

    private final EntityPromptContextFactory contextFactory;

    private final EntityDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final EntityDiscoveryResponseParser parser;

    public EntityDiscoveryResponse execute(String aggregate) {

        PromptContext context = contextFactory.create(aggregate);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}