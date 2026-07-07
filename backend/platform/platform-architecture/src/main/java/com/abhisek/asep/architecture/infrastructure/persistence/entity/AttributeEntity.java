package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "attributes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeEntity {

    @Id
    private String id;

    @Column(name = "entity_id", nullable = false)
    private String entityId;

    @Column(nullable = false)
    private String name;

    @Column(name = "data_type", nullable = false)
    private String dataType;

    @Column(nullable = false)
    private Boolean required;

    @Column(nullable = false)
    private Boolean nullable;

    @Column(name = "is_unique", nullable = false)
    private Boolean unique;

    @Column(name = "is_collection", nullable = false)
    private Boolean collection;

    @Column(name = "default_value")
    private String defaultValue;

    private Integer length;

    private Integer precision;

    private Integer scale;

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