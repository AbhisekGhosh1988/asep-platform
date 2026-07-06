package com.abhisek.asep.requirements.domain.model;

import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import com.abhisek.asep.requirements.infrastructure.ai.RequirementIssueTypeDeserializer;
import com.abhisek.asep.requirements.infrastructure.ai.RequirementSeverityDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementIssue {

    @JsonDeserialize(
            using = RequirementIssueTypeDeserializer.class)
    private RequirementIssueType type;
    @JsonDeserialize(
            using = RequirementSeverityDeserializer.class)
    private RequirementIssueSeverity severity;

    private String title;

    private String description;

}