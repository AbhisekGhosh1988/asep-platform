package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.request.AddProjectMemberRequest;
import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;

public interface AddProjectMemberUseCase {

    ProjectMemberResponse execute(String projectId, AddProjectMemberRequest request);

}