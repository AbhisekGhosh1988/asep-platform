package com.abhisek.asep.project.domain.model;

import com.abhisek.asep.project.domain.enums.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSettings {

    private String id;

    private String projectId;

    private String repositoryUrl;

    private String defaultBranch;

    private BackendFramework backendFramework;

    private FrontendFramework frontendFramework;

    private DatabaseType database;

    private BuildTool buildTool;

    private Integer javaVersion;

    private ContainerPlatform containerPlatform;

    private CloudProvider cloudProvider;

    private AIProvider aiProvider;

    private LLMModel llmModel;

    private ArchitectureStyle architectureStyle;

    private Instant createdAt;

    private Instant updatedAt;

}