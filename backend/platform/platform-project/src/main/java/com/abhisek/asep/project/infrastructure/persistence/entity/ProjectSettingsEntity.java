package com.abhisek.asep.project.infrastructure.persistence.entity;

import com.abhisek.asep.project.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(
        name = "project_settings",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_project_settings_project",
                        columnNames = "project_id"
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSettingsEntity {

    @Id
    private String id;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "repository_url")
    private String repositoryUrl;

    @Column(name = "default_branch")
    private String defaultBranch;

    @Enumerated(EnumType.STRING)
    private BackendFramework backendFramework;

    @Enumerated(EnumType.STRING)
    private FrontendFramework frontendFramework;

    @Enumerated(EnumType.STRING)
    private DatabaseType database;

    @Enumerated(EnumType.STRING)
    private BuildTool buildTool;

    private Integer javaVersion;

    @Enumerated(EnumType.STRING)
    private ContainerPlatform containerPlatform;

    @Enumerated(EnumType.STRING)
    private CloudProvider cloudProvider;

    @Enumerated(EnumType.STRING)
    private AIProvider aiProvider;

    @Enumerated(EnumType.STRING)
    private LLMModel llmModel;

    @Enumerated(EnumType.STRING)
    private ArchitectureStyle architectureStyle;

    private Instant createdAt;

    private Instant updatedAt;

}