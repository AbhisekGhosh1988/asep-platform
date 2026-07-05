package com.abhisek.asep.requirements.domain.model;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.enums.TraceRelationType;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraceLink {

    private String id;

    private TraceEntityType sourceType;

    private String sourceId;

    private TraceEntityType targetType;

    private String targetId;

    private TraceRelationType relationType;

    private String createdBy;

    private Instant createdAt;

}