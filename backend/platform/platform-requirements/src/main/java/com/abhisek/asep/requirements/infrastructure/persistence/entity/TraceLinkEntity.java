package com.abhisek.asep.requirements.infrastructure.persistence.entity;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.enums.TraceRelationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "trace_links")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraceLinkEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_type", nullable = false)
    private TraceEntityType sourceType;

    @Column(name = "source_id", nullable = false)
    private String sourceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false)
    private TraceEntityType targetType;

    @Column(name = "target_id", nullable = false)
    private String targetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "relation_type", nullable = false)
    private TraceRelationType relationType;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Instant createdAt;

}