package com.abhisek.asep.project.infrastructure.persistence.repository;

import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaProjectMemberRepository extends JpaRepository<ProjectMemberEntity, String> {

    List<ProjectMemberEntity> findByProjectId(String projectId);

    Optional<ProjectMemberEntity> findByProjectIdAndUserId(String projectId, String userId);

    long countByProjectId(String projectId);

}