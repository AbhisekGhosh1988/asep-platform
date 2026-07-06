package com.abhisek.asep.architecture.application.dto.response;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectureResponse {

    private String id;

    private String projectId;

    private String name;

    private String description;

    private ArchitectureStyle style;

    private ArchitectureStatus status;

    private Integer version;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}