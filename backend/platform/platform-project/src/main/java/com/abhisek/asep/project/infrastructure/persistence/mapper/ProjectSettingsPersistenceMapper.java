package com.abhisek.asep.project.infrastructure.persistence.mapper;

import com.abhisek.asep.project.domain.model.ProjectSettings;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectSettingsEntity;

public interface ProjectSettingsPersistenceMapper {
    ProjectSettingsEntity toEntity(ProjectSettings settings);
    ProjectSettings toDomain(ProjectSettingsEntity settings);
}
