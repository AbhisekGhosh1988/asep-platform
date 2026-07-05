package com.abhisek.asep.requirements.domain.repository;

import com.abhisek.asep.core.domain.repository.Repository;
import com.abhisek.asep.requirements.domain.model.Requirement;

import java.util.List;
import java.util.Optional;

public interface RequirementRepository extends Repository {

    Requirement save(Requirement requirement);

    Optional<Requirement> findById(String id);

    List<Requirement> findByProjectId(String projectId);

    boolean existsByProjectIdAndTitle(String projectId, String title);

    void deleteById(String id);

}