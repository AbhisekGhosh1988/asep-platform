package com.abhisek.asep.project.application.dto.request;

import com.abhisek.asep.project.domain.enums.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateProjectSettingsRequest {

    private String repositoryUrl;

    private String defaultBranch;

    @NotNull
    private BackendFramework backendFramework;

    @NotNull
    private FrontendFramework frontendFramework;

    @NotNull
    private DatabaseType database;

    @NotNull
    private BuildTool buildTool;

    @NotNull
    private Integer javaVersion;

    @NotNull
    private ContainerPlatform containerPlatform;

    @NotNull
    private CloudProvider cloudProvider;

    @NotNull
    private AIProvider aiProvider;

    @NotNull
    private LLMModel llmModel;

    @NotNull
    private ArchitectureStyle architectureStyle;

}