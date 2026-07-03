package com.abhisek.asep.project.infrastructure.persistence.entity;

import com.abhisek.asep.project.domain.model.AIProvider;
import com.abhisek.asep.project.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "projects")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 5000)
    private String description;

    @Column(nullable = false)
    private String ownerId;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Enumerated(EnumType.STRING)
    private AIProvider aiProvider;

    @Column(name = "backend")
    private String backend;

    @Column(name = "frontend")
    private String frontend;

    @Column(name = "database_name")
    private String database;

    @Column(name = "messaging")
    private String messaging;

    @Column(name = "build_tool")
    private String buildTool;

    @Column(name = "cloud")
    private String cloud;

    @Column(name = "container")
    private String container;

    private Instant createdAt;

    private Instant updatedAt;

}