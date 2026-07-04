package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;

import java.util.List;

public interface ListProjectMembersUseCase {

    List<ProjectMemberResponse> execute(String projectId);

}