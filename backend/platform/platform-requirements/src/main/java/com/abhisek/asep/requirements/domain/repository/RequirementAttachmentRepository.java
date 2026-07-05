package com.abhisek.asep.requirements.domain.repository;

import com.abhisek.asep.requirements.domain.model.RequirementAttachment;

import java.util.List;
import java.util.Optional;

public interface RequirementAttachmentRepository {

    RequirementAttachment save(RequirementAttachment attachment);

    Optional<RequirementAttachment> findById(String id);

    List<RequirementAttachment> findByRequirementId(String requirementId);

    void delete(String id);

}