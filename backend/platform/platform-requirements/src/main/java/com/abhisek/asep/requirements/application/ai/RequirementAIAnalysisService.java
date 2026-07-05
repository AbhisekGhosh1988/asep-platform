package com.abhisek.asep.requirements.application.ai;

import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;

public interface RequirementAIAnalysisService {

    RequirementAnalysis analyze(
            String requirementId);

}