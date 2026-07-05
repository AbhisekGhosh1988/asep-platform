package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementAIAnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRequirementAIAnalysisRepository extends JpaRepository<RequirementAIAnalysisEntity, String> {

    Optional<RequirementAIAnalysisEntity> findByRequirementId(String requirementId);

}