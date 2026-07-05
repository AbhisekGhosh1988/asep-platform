package com.abhisek.asep.requirements.domain.snapshot;

import com.abhisek.asep.requirements.domain.enums.*;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementSnapshot {

    private String id;

    private String projectId;

    private String title;

    private String description;

    private RequirementType type;

    private RequirementStatus status;

    private Priority priority;

    private Complexity complexity;

    private Source source;

    private Risk risk;

    private Integer version;

    private String parentRequirementId;

    private Set<String> tags;

    private String approvedBy;

}