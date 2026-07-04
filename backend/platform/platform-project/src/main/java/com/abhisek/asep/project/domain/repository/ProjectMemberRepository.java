package com.abhisek.asep.project.domain.repository;

import com.abhisek.asep.project.domain.model.ProjectMember;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberRepository {

    ProjectMember save(ProjectMember member);

    List<ProjectMember> findByProjectId(String projectId);

    Optional<ProjectMember> findByProjectIdAndUserId(String projectId, String userId);

    void delete(ProjectMember member);
    long countByProjectId(String projectId);

}