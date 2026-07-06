package com.abhisek.asep.architecture.application.service;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.mapper.ArchitectureApplicationMapper;
import com.abhisek.asep.architecture.application.usecase.ListArchitecturesUseCase;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.core.application.usecase.AbstractQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListArchitecturesUseCaseImpl extends AbstractQueryUseCase implements ListArchitecturesUseCase {

    private final ArchitectureRepository repository;
    private final ArchitectureApplicationMapper mapper;

    @Override
    public List<ArchitectureResponse> execute(String projectId) {

        return repository.findByProjectId(projectId).stream().map(mapper::toResponse).toList();

    }

}