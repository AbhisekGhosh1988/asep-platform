package com.abhisek.asep.architecture.application.design.policy.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.policy.ai.context.PolicyPromptContextFactory;
import com.abhisek.asep.architecture.application.design.policy.ai.dto.PolicyDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.policy.ai.parser.PolicyDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.policy.ai.prompt.PolicyDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PolicyDefinitionDiscoveryWorkflow {

    private final PolicyPromptContextFactory contextFactory;

    private final PolicyDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final PolicyDefinitionDiscoveryResponseParser parser;

    public PolicyDefinitionDiscoveryResponse execute(
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