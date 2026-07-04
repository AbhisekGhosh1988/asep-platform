package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.service.ProjectMemberService;
import com.abhisek.asep.project.application.usecase.RemoveProjectMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveProjectMemberUseCaseImpl implements RemoveProjectMemberUseCase {

    private final ProjectMemberService projectMemberService;

    @Override
    public void execute(String projectId, String userId) {

        projectMemberService.removeMember(projectId, userId);

    }

}