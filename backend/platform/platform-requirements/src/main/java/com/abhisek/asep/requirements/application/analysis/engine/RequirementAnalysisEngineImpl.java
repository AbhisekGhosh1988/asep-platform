package com.abhisek.asep.requirements.application.analysis.engine;

import com.abhisek.asep.requirements.application.analysis.analyzer.RequirementAnalyzer;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequirementAnalysisEngineImpl implements RequirementAnalysisEngine {

    private final List<RequirementAnalyzer> analyzers;

    @Override
    public RequirementAnalysis analyze(Requirement requirement) {

        RequirementAnalysis analysis = RequirementAnalysis.builder().requirement(requirement).qualityScore(100).build();

        analyzers.forEach(analyzer -> analyzer.analyze(requirement, analysis));

        int score = Math.max(0, 100 - analysis.getIssues().size() * 5);

        analysis.setQualityScore(score);

        return analysis;

    }

}