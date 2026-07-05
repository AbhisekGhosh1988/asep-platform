package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementTraceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRequirementTraceRepository extends JpaRepository<RequirementTraceEntity, String> {

    List<RequirementTraceEntity> findByRequirementId(String requirementId);

}