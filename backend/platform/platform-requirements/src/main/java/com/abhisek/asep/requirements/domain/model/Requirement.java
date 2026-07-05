package com.abhisek.asep.requirements.domain.model;

import com.abhisek.asep.requirements.domain.enums.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Requirement {

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

    private String createdBy;

    private String approvedBy;

    private Instant createdAt;

    private Instant updatedAt;

    private String updatedBy;


}