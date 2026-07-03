package com.abhisek.asep.project.infrastructure.persistence.repository;

import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProjectRepository
        extends JpaRepository<ProjectEntity, String> {

    Optional<ProjectEntity> findByName(String name);

    boolean existsByName(String name);

}