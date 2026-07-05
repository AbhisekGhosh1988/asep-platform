package com.abhisek.asep.requirements.domain.model;

import lombok.*;

import java.time.Instant;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAIAnalysis {
    private Long id;
    private Long requirementId;
    private Double completenessScore;
    private Double ambiguityScore;
    private Double qualityScore;
    private String analysis;
    private Instant createdAt;
}
