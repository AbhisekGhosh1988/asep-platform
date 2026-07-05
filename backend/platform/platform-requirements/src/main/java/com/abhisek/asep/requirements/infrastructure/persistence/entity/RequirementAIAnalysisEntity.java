package com.abhisek.asep.requirements.infrastructure.persistence.entity;
import com.abhisek.asep.project.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "requirement_ai_analysis")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAIAnalysisEntity {

    @Id
    private String id;

    private String requirementId;

    private Double completenessScore;

    private Double ambiguityScore;

    private Double qualityScore;

    @Column(columnDefinition = "TEXT")
    private String analysis;

    private Instant createdAt;

}