package com.abhisek.asep.project.domain.model;

import com.abhisek.asep.project.domain.enums.AIProvider;
import com.abhisek.asep.project.domain.enums.ProjectStatus;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private String id;

    private String name;

    private String description;

    private String ownerId;

    private ProjectStatus status;

    private AIProvider aiProvider;

    private TechStack techStack;

    private Instant createdAt;

    private Instant updatedAt;

}