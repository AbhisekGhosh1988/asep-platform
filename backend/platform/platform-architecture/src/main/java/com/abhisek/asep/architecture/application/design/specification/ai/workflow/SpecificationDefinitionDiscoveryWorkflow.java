package com.abhisek.asep.architecture.application.design.specification.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.specification.ai.context.SpecificationPromptContextFactory;
import com.abhisek.asep.architecture.application.design.specification.ai.dto.SpecificationDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.specification.ai.parser.SpecificationDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.specification.ai.prompt.SpecificationDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecificationDefinitionDiscoveryWorkflow {

    private final SpecificationPromptContextFactory contextFactory;

    private final SpecificationDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final SpecificationDefinitionDiscoveryResponseParser parser;

    public SpecificationDefinitionDiscoveryResponse execute(
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