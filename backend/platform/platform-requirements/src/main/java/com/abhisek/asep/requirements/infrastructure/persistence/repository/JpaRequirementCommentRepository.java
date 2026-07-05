package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.infrastructure.persistence.entity.RequirementCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRequirementCommentRepository
        extends JpaRepository<RequirementCommentEntity, String> {

    List<RequirementCommentEntity> findByRequirementId(String requirementId);

}