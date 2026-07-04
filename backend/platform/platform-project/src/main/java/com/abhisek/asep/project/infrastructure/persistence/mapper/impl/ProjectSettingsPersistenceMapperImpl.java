package com.abhisek.asep.project.infrastructure.persistence.mapper.impl;

import com.abhisek.asep.project.domain.model.ProjectSettings;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectSettingsEntity;
import com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectSettingsPersistenceMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectSettingsPersistenceMapperImpl implements ProjectSettingsPersistenceMapper {

    @Override
    public ProjectSettingsEntity toEntity(ProjectSettings settings) {

        if (settings == null) {
            return null;
        }

        return ProjectSettingsEntity.builder().id(settings.getId()).projectId(settings.getProjectId()).repositoryUrl(settings.getRepositoryUrl()).defaultBranch(settings.getDefaultBranch()).backendFramework(settings.getBackendFramework()).frontendFramework(settings.getFrontendFramework()).database(settings.getDatabase()).buildTool(settings.getBuildTool()).javaVersion(settings.getJavaVersion()).containerPlatform(settings.getContainerPlatform()).cloudProvider(settings.getCloudProvider()).aiProvider(settings.getAiProvider()).llmModel(settings.getLlmModel()).architectureStyle(settings.getArchitectureStyle()).createdAt(settings.getCreatedAt()).updatedAt(settings.getUpdatedAt()).build();

    }

    @Override
    public ProjectSettings toDomain(ProjectSettingsEntity entity) {

        if (entity == null) {
            return null;
        }

        return ProjectSettings.builder().id(entity.getId()).projectId(entity.getProjectId()).repositoryUrl(entity.getRepositoryUrl()).defaultBranch(entity.getDefaultBranch()).backendFramework(entity.getBackendFramework()).frontendFramework(entity.getFrontendFramework()).database(entity.getDatabase()).buildTool(entity.getBuildTool()).javaVersion(entity.getJavaVersion()).containerPlatform(entity.getContainerPlatform()).cloudProvider(entity.getCloudProvider()).aiProvider(entity.getAiProvider()).llmModel(entity.getLlmModel()).architectureStyle(entity.getArchitectureStyle()).createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();

    }

}

