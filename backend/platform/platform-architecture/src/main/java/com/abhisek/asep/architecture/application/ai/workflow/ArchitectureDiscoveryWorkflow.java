package com.abhisek.asep.architecture.application.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.ai.context.ArchitecturePromptContextFactory;
import com.abhisek.asep.architecture.application.ai.dto.ArchitectureDiscoveryResponse;
import com.abhisek.asep.architecture.application.ai.parser.ArchitectureDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.ai.prompt.ArchitectureDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArchitectureDiscoveryWorkflow {

    private final ArchitecturePromptContextFactory contextFactory;

    private final ArchitectureDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final ArchitectureDiscoveryResponseParser parser;

    public ArchitectureDiscoveryResponse execute(String requirements) {

        PromptContext context = contextFactory.create(requirements);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}