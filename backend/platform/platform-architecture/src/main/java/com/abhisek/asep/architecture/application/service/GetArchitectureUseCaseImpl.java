package com.abhisek.asep.architecture.application.service;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.mapper.ArchitectureApplicationMapper;
import com.abhisek.asep.architecture.application.usecase.GetArchitectureUseCase;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.core.application.usecase.AbstractQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArchitectureUseCaseImpl extends AbstractQueryUseCase implements GetArchitectureUseCase {

    private final ArchitectureRepository repository;
    private final ArchitectureApplicationMapper mapper;

    @Override
    public ArchitectureResponse execute(String architectureId) {

        return repository.findById(architectureId).map(mapper::toResponse).orElseThrow(() -> new IllegalArgumentException("Architecture not found"));

    }

}