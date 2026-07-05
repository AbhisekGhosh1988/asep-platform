package com.abhisek.asep.requirements.domain.repository;

import com.abhisek.asep.requirements.domain.model.RequirementComment;

import java.util.List;
import java.util.Optional;

public interface RequirementCommentRepository {

    RequirementComment save(RequirementComment comment);

    List<RequirementComment> findByRequirementId(String requirementId);

    Optional<RequirementComment> findById(String id);

    void delete(String id);

}