package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRequirementVersionRepository extends JpaRepository<RequirementVersionEntity, String> {

    List<RequirementVersionEntity> findByRequirementIdOrderByVersionDesc(String requirementId);

}