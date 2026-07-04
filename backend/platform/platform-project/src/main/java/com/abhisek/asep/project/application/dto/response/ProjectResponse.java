package com.abhisek.asep.project.application.dto.response;

import com.abhisek.asep.project.domain.enums.AIProvider;
import com.abhisek.asep.project.domain.enums.ProjectStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ProjectResponse {

    private String id;

    private String name;

    private String description;

    private String ownerId;

    private ProjectStatus status;

    private AIProvider aiProvider;

    private Instant createdAt;

    private Instant updatedAt;

}