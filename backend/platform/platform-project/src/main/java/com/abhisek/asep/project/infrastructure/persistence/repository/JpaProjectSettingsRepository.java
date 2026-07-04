package com.abhisek.asep.project.infrastructure.persistence.repository;

import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProjectSettingsRepository
        extends JpaRepository<ProjectSettingsEntity, String> {

    Optional<ProjectSettingsEntity> findByProjectId(String projectId);

}