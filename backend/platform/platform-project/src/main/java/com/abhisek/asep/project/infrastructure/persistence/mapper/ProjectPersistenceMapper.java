package com.abhisek.asep.project.infrastructure.persistence.mapper;

import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectEntity;

public interface ProjectPersistenceMapper {
    ProjectEntity toEntity(Project project);

    Project toDomain(ProjectEntity entity);
}
