package com.abhisek.asep.requirements.application.analysis.analyzer;

import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.domain.model.RequirementIssue;
import org.springframework.stereotype.Component;

@Component
public class CompletenessAnalyzer implements RequirementAnalyzer {

    @Override
    public void analyze(Requirement requirement, RequirementAnalysis analysis) {

        if (requirement.getTitle() == null || requirement.getTitle().isBlank()) {

            analysis.getIssues().add(

                    RequirementIssue.builder().type(RequirementIssueType.INCOMPLETE).severity(RequirementIssueSeverity.HIGH).title("Missing title").description("Requirement title is mandatory.").build());

        }

        if (requirement.getDescription() == null || requirement.getDescription().isBlank()) {

            analysis.getIssues().add(

                    RequirementIssue.builder().type(RequirementIssueType.INCOMPLETE).severity(RequirementIssueSeverity.CRITICAL).title("Missing description").description("Requirement description is mandatory.").build());

        }

    }

}