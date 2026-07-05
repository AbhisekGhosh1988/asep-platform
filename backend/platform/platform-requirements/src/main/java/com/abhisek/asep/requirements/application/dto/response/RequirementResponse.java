package com.abhisek.asep.requirements.application.dto.response;

import com.abhisek.asep.requirements.domain.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Requirement Response")
public class RequirementResponse {

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

}