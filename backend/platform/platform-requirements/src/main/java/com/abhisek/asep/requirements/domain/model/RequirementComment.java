package com.abhisek.asep.requirements.domain.model;

import lombok.*;

import java.time.Instant;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequirementComment {
    private String id;
    private String requirementId;
    private String comment;
    private String commentedBy;
    private Instant commentedAt;
    private String createdBy;
    private Instant createdAt;
}
