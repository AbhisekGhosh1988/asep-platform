package com.abhisek.asep.requirements.application.ai;

import com.abhisek.asep.ai.core.orchestrator.AIOrchestrator;
import com.abhisek.asep.ai.prompt.builder.requirement.RequirementAnalysisPromptBuilder;
import com.abhisek.asep.ai.prompt.builder.requirement.RequirementPromptVariables;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import com.abhisek.asep.requirements.infrastructure.ai.RequirementAnalysisResponseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequirementAIAnalysisServiceImpl
        implements RequirementAIAnalysisService {

    private final RequirementRepository repository;

    private final RequirementAnalysisPromptBuilder promptBuilder;

    private final RequirementAnalysisResponseParser parser;

    private final AIOrchestrator orchestrator;

    @Override
    public RequirementAnalysis analyze(
            String requirementId) {

        Requirement requirement = repository.findById(requirementId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Requirement not found"));

        PromptContext context = PromptContext.builder()
                .build();

        context.put(RequirementPromptVariables.TITLE, requirement.getTitle());
        context.put(RequirementPromptVariables.DESCRIPTION, requirement.getDescription());
        context.put(RequirementPromptVariables.TYPE, requirement.getType());
        context.put(RequirementPromptVariables.PRIORITY, requirement.getPriority());
        context.put(RequirementPromptVariables.COMPLEXITY, requirement.getComplexity());

        return orchestrator.execute(
                promptBuilder,
                context,
                parser);
    }
}