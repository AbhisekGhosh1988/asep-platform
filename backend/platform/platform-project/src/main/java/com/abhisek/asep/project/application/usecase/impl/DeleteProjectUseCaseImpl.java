package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.usecase.DeleteProjectUseCase;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {

    private final ProjectRepository repository;

    @Override
    public void execute(String id) {

        if (!repository.existsById(id)) {
            throw new ProjectNotFoundException(
                    "Project not found: " + id);
        }

        repository.deleteById(id);
    }
}