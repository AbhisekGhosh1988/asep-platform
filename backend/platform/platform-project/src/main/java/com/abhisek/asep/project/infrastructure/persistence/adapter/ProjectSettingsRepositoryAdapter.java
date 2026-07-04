package com.abhisek.asep.project.infrastructure.persistence.adapter;

import com.abhisek.asep.project.domain.model.ProjectSettings;
import com.abhisek.asep.project.domain.repository.ProjectSettingsRepository;
import com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectSettingsPersistenceMapper;
import com.abhisek.asep.project.infrastructure.persistence.repository.JpaProjectSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectSettingsRepositoryAdapter implements ProjectSettingsRepository {

    private final JpaProjectSettingsRepository repository;
    private final ProjectSettingsPersistenceMapper mapper;

    @Override
    public ProjectSettings save(ProjectSettings settings) {

        return mapper.toDomain(repository.save(mapper.toEntity(settings)));

    }

    @Override
    public Optional<ProjectSettings> findByProjectId(String projectId) {

        return repository.findByProjectId(projectId).map(mapper::toDomain);

    }

}