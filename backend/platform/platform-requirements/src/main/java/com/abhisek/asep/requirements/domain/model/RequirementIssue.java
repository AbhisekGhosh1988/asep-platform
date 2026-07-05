package com.abhisek.asep.requirements.domain.model;

import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementIssue {

    private RequirementIssueType type;

    private RequirementIssueSeverity severity;

    private String title;

    private String description;

}