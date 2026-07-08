package com.abhisek.asep.architecture.application.design.apicontract.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.architecture.application.design.apicontract.ai.context.ApiContractPromptContextFactory;
import com.abhisek.asep.architecture.application.design.apicontract.ai.dto.ApiContractDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.apicontract.ai.parser.ApiContractDiscoveryResponseParser;
import com.abhisek.asep.architecture.application.design.apicontract.ai.prompt.ApiContractDiscoveryPromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiContractDiscoveryWorkflow {

    private final ApiContractPromptContextFactory contextFactory;

    private final ApiContractDiscoveryPromptBuilder promptBuilder;

    private final AIService aiService;

    private final ApiContractDiscoveryResponseParser parser;

    public ApiContractDiscoveryResponse execute(String aggregateModel) {

        PromptContext context = contextFactory.create(aggregateModel);

        AIRequest request = promptBuilder.build(context);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}