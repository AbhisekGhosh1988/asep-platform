package com.abhisek.asep.project.application.service.impl;

import com.abhisek.asep.project.application.dto.request.UpdateProjectSettingsRequest;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.mapper.ProjectSettingsApplicationMapper;
import com.abhisek.asep.project.application.service.ProjectSettingsService;
import com.abhisek.asep.project.domain.model.ProjectSettings;
import com.abhisek.asep.project.domain.repository.ProjectSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class ProjectSettingsServiceImpl implements ProjectSettingsService {

    private final ProjectSettingsRepository repository;

    private final ProjectSettingsApplicationMapper mapper;

    @Override
    public ProjectSettingsResponse getSettings(String projectId) {

        ProjectSettings settings = repository.findByProjectId(projectId).orElseThrow(() -> new IllegalArgumentException("Project settings not found"));

        return mapper.toResponse(settings);

    }

    @Override
    public ProjectSettingsResponse updateSettings(String projectId, UpdateProjectSettingsRequest request) {

        ProjectSettings settings = repository.findByProjectId(projectId).orElseThrow(() -> new IllegalArgumentException("Project settings not found"));

        settings.setRepositoryUrl(request.getRepositoryUrl());
        settings.setDefaultBranch(request.getDefaultBranch());

        settings.setBackendFramework(request.getBackendFramework());
        settings.setFrontendFramework(request.getFrontendFramework());
        settings.setDatabase(request.getDatabase());

        settings.setBuildTool(request.getBuildTool());

        settings.setJavaVersion(request.getJavaVersion());

        settings.setContainerPlatform(request.getContainerPlatform());

        settings.setCloudProvider(request.getCloudProvider());

        settings.setAiProvider(request.getAiProvider());

        settings.setLlmModel(request.getLlmModel());

        settings.setArchitectureStyle(request.getArchitectureStyle());

        settings.setUpdatedAt(Instant.now());

        repository.save(settings);

        return mapper.toResponse(settings);

    }

}