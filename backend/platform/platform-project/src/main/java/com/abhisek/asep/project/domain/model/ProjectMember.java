package com.abhisek.asep.project.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {

    private String id;

    private String projectId;

    private String userId;

    private ProjectRole role;

    private Instant joinedAt;

}