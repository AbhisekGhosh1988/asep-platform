package com.abhisek.asep.requirements.application.ai;

import com.abhisek.asep.ai.core.orchestrator.AIOrchestrator;
import com.abhisek.asep.ai.prompt.builder.requirement.RequirementAnalysisPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.requirements.application.ai.context.RequirementPromptContextFactory;
import com.abhisek.asep.requirements.application.ai.workflow.RequirementAnalysisWorkflow;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import com.abhisek.asep.requirements.infrastructure.ai.RequirementAnalysisResponseParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequirementAIAnalysisServiceImpl implements RequirementAIAnalysisService {

    private final RequirementRepository repository;
    private final RequirementAnalysisWorkflow workflow;

    @Override
    public RequirementAnalysis analyze(String requirementId) {
        Requirement requirement = repository.findById(requirementId).orElseThrow(() ->
                new IllegalArgumentException("Requirement not found"));
        return workflow.execute(requirement);

    }

}