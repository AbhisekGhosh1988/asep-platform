package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "microservices")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroserviceEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String boundedContextId;

    @Column(nullable =false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ArchitectureStyle style;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}