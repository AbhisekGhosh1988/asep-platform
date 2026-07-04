package com.abhisek.asep.project.application.mapper.impl;

import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.application.mapper.ProjectMemberApplicationMapper;
import com.abhisek.asep.project.domain.model.ProjectMember;

public class ProjectMemberApplicationMapperImpl implements ProjectMemberApplicationMapper {

    @Override
    public ProjectMemberResponse toResponse(ProjectMember member) {

        return ProjectMemberResponse.builder().id(member.getId()).projectId(member.getProjectId()).userId(member.getUserId()).role(member.getRole()).joinedAt(member.getJoinedAt()).build();

    }

}
