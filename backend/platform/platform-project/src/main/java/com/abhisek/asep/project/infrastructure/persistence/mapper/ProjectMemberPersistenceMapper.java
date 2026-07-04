package com.abhisek.asep.project.infrastructure.persistence.mapper;

import com.abhisek.asep.project.domain.model.ProjectMember;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectMemberEntity;

public interface ProjectMemberPersistenceMapper {
    ProjectMemberEntity toEntity(ProjectMember member);
    ProjectMember toDomain(ProjectMemberEntity memberEntity);
}
