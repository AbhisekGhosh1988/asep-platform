package com.abhisek.asep.project.infrastructure.persistence.adapter;

import com.abhisek.asep.project.domain.model.ProjectMember;
import com.abhisek.asep.project.domain.repository.ProjectMemberRepository;
import com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectMemberPersistenceMapper;
import com.abhisek.asep.project.infrastructure.persistence.repository.JpaProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectMemberRepositoryAdapter implements ProjectMemberRepository {

    private final JpaProjectMemberRepository repository;
    private final ProjectMemberPersistenceMapper mapper;

    @Override
    public ProjectMember save(ProjectMember member) {

        return mapper.toDomain(repository.save(mapper.toEntity(member)));
    }

    @Override
    public List<ProjectMember> findByProjectId(String projectId) {

        return repository.findByProjectId(projectId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<ProjectMember> findByProjectIdAndUserId(String projectId, String userId) {

        return repository.findByProjectIdAndUserId(projectId, userId).map(mapper::toDomain);
    }

    @Override
    public void delete(ProjectMember member) {

        repository.delete(mapper.toEntity(member));
    }
    @Override
    public long countByProjectId(String projectId) {

        return repository.countByProjectId(projectId);

    }
}