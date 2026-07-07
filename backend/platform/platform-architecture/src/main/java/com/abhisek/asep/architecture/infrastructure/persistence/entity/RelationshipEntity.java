package com.abhisek.asep.architecture.infrastructure.persistence.entity;

import com.abhisek.asep.architecture.domain.enums.CascadeType;
import com.abhisek.asep.architecture.domain.enums.FetchType;
import com.abhisek.asep.architecture.domain.enums.RelationshipType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "relationships")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipEntity {

    @Id
    private String id;

    @Column(name = "source_entity_id", nullable = false)
    private String sourceEntityId;

    @Column(name = "target_entity_id", nullable = false)
    private String targetEntityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_type", nullable = false)
    private RelationshipType relationshipType;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "mapped_by")
    private String mappedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "cascade_type", nullable = false)
    private CascadeType cascadeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "fetch_type", nullable = false)
    private FetchType fetchType;

    @Column(nullable = false)
    private Boolean optional;

    @Column(name = "orphan_removal", nullable = false)
    private Boolean orphanRemoval;

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