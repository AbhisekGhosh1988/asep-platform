package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.AddProjectMemberRequest;
import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.application.service.ProjectMemberService;
import com.abhisek.asep.project.application.usecase.AddProjectMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddProjectMemberUseCaseImpl implements AddProjectMemberUseCase {

    private final ProjectMemberService projectMemberService;

    @Override
    public ProjectMemberResponse execute(String projectId, AddProjectMemberRequest request) {

        return projectMemberService.addMember(projectId, request);

    }

}