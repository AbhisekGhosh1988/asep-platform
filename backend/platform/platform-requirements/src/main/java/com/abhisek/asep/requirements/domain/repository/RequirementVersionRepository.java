package com.abhisek.asep.requirements.domain.repository;

import com.abhisek.asep.requirements.domain.model.RequirementVersion;

import java.util.List;
import java.util.Optional;

public interface RequirementVersionRepository {

    RequirementVersion save(
            RequirementVersion version);

    Optional<RequirementVersion> findById(
            String id);

    List<RequirementVersion> findByRequirementId(
            String requirementId);

    Optional<RequirementVersion> findByRequirementIdAndVersion(
            String requirementId,
            Integer version);

}