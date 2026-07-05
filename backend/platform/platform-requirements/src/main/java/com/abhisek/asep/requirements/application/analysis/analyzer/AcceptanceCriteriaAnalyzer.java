package com.abhisek.asep.requirements.application.analysis.analyzer;

import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.domain.model.RequirementIssue;
import org.springframework.stereotype.Component;

@Component
public class AcceptanceCriteriaAnalyzer implements RequirementAnalyzer {

    @Override
    public void analyze(Requirement requirement, RequirementAnalysis analysis) {

        if (requirement.getDescription() == null) {
            return;
        }

        String text = requirement.getDescription().toLowerCase();

        if (!text.contains("given") || !text.contains("when") || !text.contains("then")) {

            analysis.getIssues().add(

                    RequirementIssue.builder().type(RequirementIssueType.ACCEPTANCE_CRITERIA).severity(RequirementIssueSeverity.MEDIUM).title("Acceptance criteria missing").description("Consider adding Given-When-Then acceptance criteria.").build());

        }

    }

}