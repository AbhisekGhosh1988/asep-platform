package com.abhisek.asep.project.domain.repository;

import com.abhisek.asep.project.domain.model.ProjectSettings;

import java.util.Optional;

public interface ProjectSettingsRepository {

    ProjectSettings save(ProjectSettings settings);

    Optional<ProjectSettings> findByProjectId(String projectId);

}