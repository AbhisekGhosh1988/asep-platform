package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "architectures")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectureEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "style", nullable = false)
    private ArchitectureStyle style;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ArchitectureStatus status;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

}