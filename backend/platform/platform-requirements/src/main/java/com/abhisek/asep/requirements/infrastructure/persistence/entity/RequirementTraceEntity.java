package com.abhisek.asep.requirements.infrastructure.persistence.entity;
import com.abhisek.asep.project.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "requirement_traces")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementTraceEntity {

    @Id
    private String id;

    private String requirementId;

    private String targetType;

    private String targetId;

    private Instant createdAt;

}