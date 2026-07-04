package com.abhisek.asep.project.application.mapper.impl;

import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.mapper.ProjectSettingsApplicationMapper;
import com.abhisek.asep.project.domain.model.ProjectSettings;
import org.springframework.stereotype.Component;

@Component
public class ProjectSettingsApplicationMapperImpl implements ProjectSettingsApplicationMapper {
    @Override
    public ProjectSettingsResponse toResponse(ProjectSettings settings) {
        return ProjectSettingsResponse.builder().projectId(settings.getProjectId()).repositoryUrl(settings.getRepositoryUrl()).defaultBranch(settings.getDefaultBranch()).backendFramework(settings.getBackendFramework()).frontendFramework(settings.getFrontendFramework()).database(settings.getDatabase()).buildTool(settings.getBuildTool()).javaVersion(settings.getJavaVersion()).containerPlatform(settings.getContainerPlatform()).cloudProvider(settings.getCloudProvider()).aiProvider(settings.getAiProvider()).llmModel(settings.getLlmModel()).architectureStyle(settings.getArchitectureStyle()).build();

    }
}
