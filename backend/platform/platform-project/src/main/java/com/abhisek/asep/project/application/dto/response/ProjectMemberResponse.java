package com.abhisek.asep.project.application.dto.response;

import com.abhisek.asep.project.domain.enums.ProjectRole;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ProjectMemberResponse {

    private String id;

    private String projectId;

    private String userId;

    private ProjectRole role;

    private Instant joinedAt;

}