package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "specification_definitions", uniqueConstraints = {@UniqueConstraint(name = "uk_specification_definition",
        columnNames = {"aggregate_id", "name"})})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDefinitionEntity {

    @Id
    private String id;

    @Column(name = "aggregate_id", nullable = false)
    private String aggregateId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

}