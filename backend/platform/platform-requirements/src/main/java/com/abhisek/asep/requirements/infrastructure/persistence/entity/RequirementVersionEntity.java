package com.abhisek.asep.requirements.infrastructure.persistence.entity;
import com.abhisek.asep.project.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Entity
@Table(name = "requirement_versions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementVersionEntity {

    @Id
    private String id;

    private String requirementId;

    private Integer version;

    @Column(columnDefinition = "TEXT")
    private String snapshot;

    private String createdBy;

    private Instant createdAt;

}