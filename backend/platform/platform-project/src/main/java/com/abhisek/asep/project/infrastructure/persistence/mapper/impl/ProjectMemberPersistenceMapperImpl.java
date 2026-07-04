package com.abhisek.asep.project.infrastructure.persistence.mapper.impl;

import com.abhisek.asep.project.domain.model.ProjectMember;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectMemberEntity;
import com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectMemberPersistenceMapper;

public class ProjectMemberPersistenceMapperImpl implements ProjectMemberPersistenceMapper {
    @Override
    public ProjectMemberEntity toEntity(ProjectMember member) {

        if (member == null) {
            return null;
        }

        return ProjectMemberEntity.builder().id(member.getId()).projectId(member.getProjectId()).userId(member.getUserId()).role(member.getRole()).joinedAt(member.getJoinedAt()).build();
    }

    @Override
    public ProjectMember toDomain(ProjectMemberEntity memberEntity) {

        if (memberEntity == null) {
            return null;
        }

        return ProjectMember.builder().id(memberEntity.getId()).projectId(memberEntity.getProjectId()).userId(memberEntity.getUserId()).role(memberEntity.getRole()).joinedAt(memberEntity.getJoinedAt()).build();
    }
}
