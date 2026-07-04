package com.abhisek.asep.project.application.mapper;

import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.domain.model.ProjectMember;

public interface ProjectMemberApplicationMapper {
    ProjectMemberResponse toResponse(ProjectMember member);
}
