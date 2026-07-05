package com.abhisek.asep.requirements.application.analysis.engine;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;

public interface RequirementAnalysisEngine {

    RequirementAnalysis analyze(
            Requirement requirement);

}