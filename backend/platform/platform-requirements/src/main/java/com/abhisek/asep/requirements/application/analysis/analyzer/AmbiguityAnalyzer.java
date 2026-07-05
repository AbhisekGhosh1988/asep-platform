package com.abhisek.asep.requirements.application.analysis.analyzer;

import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.abhisek.asep.requirements.domain.model.RequirementIssue;
import org.springframework.stereotype.Component;

@Component
public class AmbiguityAnalyzer implements RequirementAnalyzer {

    private static final String[] AMBIGUOUS_TERMS = {

            "fast",

            "quick",

            "easy",

            "simple",

            "etc",

            "maybe",

            "approximately",

            "user friendly",

            "efficient"

    };

    @Override
    public void analyze(Requirement requirement, RequirementAnalysis analysis) {

        if (requirement.getDescription() == null) {
            return;
        }

        String text = requirement.getDescription().toLowerCase();

        for (String term : AMBIGUOUS_TERMS) {

            if (text.contains(term)) {

                analysis.getIssues().add(

                        RequirementIssue.builder().type(RequirementIssueType.AMBIGUITY).severity(RequirementIssueSeverity.MEDIUM).title("Ambiguous wording").description("Contains ambiguous term: " + term).build());

            }

        }

    }

}