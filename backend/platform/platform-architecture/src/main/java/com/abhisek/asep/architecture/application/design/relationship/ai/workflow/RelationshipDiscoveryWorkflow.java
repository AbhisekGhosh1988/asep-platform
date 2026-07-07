package com.abhisek.asep.architecture.application.design.relationship.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.relationship.ai.context.RelationshipPromptContextFactory;
import com.abhisek.asep.architecture.application.design.relationship.ai.dto.RelationshipDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.relationship.ai.parser.RelationshipDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.relationship.ai.prompt.RelationshipDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationshipDiscoveryWorkflow {

    private final RelationshipPromptContextFactory contextFactory;

    private final RelationshipDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final RelationshipDiscoveryResponseParser parser;

    public RelationshipDiscoveryResponse execute(
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