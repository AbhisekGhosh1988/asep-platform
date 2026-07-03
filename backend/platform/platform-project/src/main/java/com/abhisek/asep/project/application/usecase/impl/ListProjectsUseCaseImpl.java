package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.usecase.ListProjectsUseCase;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProjectsUseCaseImpl implements ListProjectsUseCase {

    private final ProjectRepository repository;
    private final ProjectApplicationMapper mapper;

    @Override
    public List<ProjectResponse> execute() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}