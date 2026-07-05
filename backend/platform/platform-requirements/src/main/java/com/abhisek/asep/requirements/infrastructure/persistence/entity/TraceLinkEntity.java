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
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TraceEntityType sourceType;

    @Column(nullable = false)
    private String sourceId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TraceEntityType targetType;

    @Column(nullable = false)
    private String targetId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TraceRelationType relationType;

    private String createdBy;

    private Instant createdAt;

}