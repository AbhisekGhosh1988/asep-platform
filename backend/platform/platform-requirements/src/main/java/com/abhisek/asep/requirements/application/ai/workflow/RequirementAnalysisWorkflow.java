package com.abhisek.asep.requirements.application.ai.workflow;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.prompt.builder.requirement.RequirementAnalysisPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.infrastructure.ai.RequirementAnalysisResponseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequirementAnalysisWorkflow {

    private final PromptContextFactory<Requirement> contextFactory;

    private final RequirementAnalysisPromptBuilder promptBuilder;

    private final AIService aiService;

    private final RequirementAnalysisResponseParser parser;

    public RequirementAnalysis execute(
            Requirement requirement) {

        PromptContext context =
                contextFactory.create(requirement);

        AIRequest request =
                promptBuilder.build(context);

        AIResponse response =
                aiService.generate(request);

        return parser.parse(response);

    }

}