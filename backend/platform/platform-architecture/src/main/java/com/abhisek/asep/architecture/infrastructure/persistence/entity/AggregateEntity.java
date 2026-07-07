package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "aggregates")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String microserviceId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}