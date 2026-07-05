package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementAttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRequirementAttachmentRepository extends JpaRepository<RequirementAttachmentEntity, String> {

    List<RequirementAttachmentEntity> findByRequirementId(String requirementId);

}