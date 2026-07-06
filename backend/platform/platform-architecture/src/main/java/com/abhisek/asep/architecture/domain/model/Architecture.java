package com.abhisek.asep.architecture.domain.model;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Architecture {

    /**
     * Architecture Identifier
     */
    private String id;

    /**
     * Parent Project
     */
    private String projectId;

    /**
     * Architecture Name
     */
    private String name;

    /**
     * Architecture Description
     */
    private String description;

    /**
     * Overall Architecture Style
     */
    private ArchitectureStyle style;

    /**
     * Lifecycle Status
     */
    private ArchitectureStatus status;

    /**
     * Version Number
     */
    private Integer version;

    /**
     * Created By
     */
    private String createdBy;

    /**
     * Created Timestamp
     */
    private Instant createdAt;

    /**
     * Last Updated By
     */
    private String updatedBy;

    /**
     * Last Updated Timestamp
     */
    private Instant updatedAt;

}