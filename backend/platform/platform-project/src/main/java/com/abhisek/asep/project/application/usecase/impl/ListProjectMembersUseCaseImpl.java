package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.application.service.ProjectMemberService;
import com.abhisek.asep.project.application.usecase.ListProjectMembersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProjectMembersUseCaseImpl implements ListProjectMembersUseCase {

    private final ProjectMemberService projectMemberService;

    @Override
    public List<ProjectMemberResponse> execute(String projectId) {

        return projectMemberService.getMembers(projectId);

    }

}