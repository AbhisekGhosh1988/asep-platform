package com.abhisek.asep.requirements.domain.model;

import lombok.*;

import java.time.Instant;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequirementTrace {
    private Long id;
    private Long requirementId;
    private String targetType;
    private String targetId;
    private Instant createdAt;
}
