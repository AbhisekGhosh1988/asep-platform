package com.abhisek.asep.architecture.application.design.query.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.query.ai.context.QueryPromptContextFactory;
import com.abhisek.asep.architecture.application.design.query.ai.dto.QueryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.query.ai.parser.QueryDefinitionDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.query.ai.prompt.QueryDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryDefinitionDiscoveryWorkflow {

    private final QueryPromptContextFactory contextFactory;

    private final QueryDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final QueryDefinitionDiscoveryResponseParser parser;

    public QueryDefinitionDiscoveryResponse execute(String aggregateModel) {

        PromptContext context = contextFactory.create(aggregateModel);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}