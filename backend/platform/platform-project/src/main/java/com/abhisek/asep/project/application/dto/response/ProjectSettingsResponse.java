package com.abhisek.asep.project.application.dto.response;

import com.abhisek.asep.project.domain.enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectSettingsResponse {

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

}