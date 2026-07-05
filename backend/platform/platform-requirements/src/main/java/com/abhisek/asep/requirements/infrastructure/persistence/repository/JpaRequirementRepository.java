package com.abhisek.asep.requirements.infrastructure.persistence.repository;


import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRequirementRepository extends JpaRepository<RequirementEntity, String> {

    List<RequirementEntity> findByProjectId(String projectId);

    boolean existsByProjectIdAndTitle(String projectId, String title);

}