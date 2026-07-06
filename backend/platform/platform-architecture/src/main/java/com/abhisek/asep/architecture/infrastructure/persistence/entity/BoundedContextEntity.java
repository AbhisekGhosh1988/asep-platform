package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "bounded_contexts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContextEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String architectureId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String responsibility;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}