package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.usecase.DeleteProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {

    private final ProjectService projectService;

    @Override
    public void execute(String id) {
        projectService.delete(id);
    }
}