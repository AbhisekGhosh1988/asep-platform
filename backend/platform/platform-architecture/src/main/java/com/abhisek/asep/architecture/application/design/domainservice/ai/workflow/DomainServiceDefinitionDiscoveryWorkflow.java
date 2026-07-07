package com.abhisek.asep.architecture.application.design.domainservice.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.domainservice.ai.context.DomainServicePromptContextFactory;
import com.abhisek.asep.architecture.application.design.domainservice.ai.dto.DomainServiceDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainservice.ai.parser.DomainServiceDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.domainservice.ai.prompt.DomainServiceDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainServiceDefinitionDiscoveryWorkflow {

    private final DomainServicePromptContextFactory contextFactory;

    private final DomainServiceDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final DomainServiceDefinitionDiscoveryResponseParser parser;

    public DomainServiceDefinitionDiscoveryResponse execute(
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