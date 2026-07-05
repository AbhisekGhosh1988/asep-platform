package com.abhisek.asep.requirements.application.analysis.analyzer;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;

public interface RequirementAnalyzer {

    void analyze(
            Requirement requirement,
            RequirementAnalysis analysis);

}