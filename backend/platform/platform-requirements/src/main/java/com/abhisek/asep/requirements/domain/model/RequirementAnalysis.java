package com.abhisek.asep.requirements.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAnalysis {

    private Requirement requirement;

    @Builder.Default
    private List<RequirementIssue> issues = new ArrayList<>();

    @Builder.Default
    private List<RequirementSuggestion> suggestions = new ArrayList<>();

    private Integer qualityScore;

}