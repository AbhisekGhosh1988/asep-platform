package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.ArchitectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaArchitectureRepository
        extends JpaRepository<ArchitectureEntity, String> {

    List<ArchitectureEntity> findByProjectId(String projectId);

    boolean existsByProjectIdAndName(
            String projectId,
            String name);

}