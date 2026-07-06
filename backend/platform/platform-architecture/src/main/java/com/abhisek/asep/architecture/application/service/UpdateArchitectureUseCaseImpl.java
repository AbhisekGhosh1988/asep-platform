package com.abhisek.asep.architecture.application.service;

import com.abhisek.asep.architecture.application.dto.request.UpdateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.mapper.ArchitectureApplicationMapper;
import com.abhisek.asep.architecture.application.usecase.UpdateArchitectureUseCase;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.core.application.usecase.AbstractUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateArchitectureUseCaseImpl extends AbstractUpdateUseCase implements UpdateArchitectureUseCase {

    private final ArchitectureRepository repository;
    private final ArchitectureApplicationMapper mapper;

    @Override
    public ArchitectureResponse execute(String architectureId, UpdateArchitectureRequest request) {

        Architecture architecture = repository.findById(architectureId).orElseThrow(() -> new IllegalArgumentException("Architecture not found"));

        architecture.setName(request.getName());
        architecture.setDescription(request.getDescription());
        architecture.setStyle(request.getStyle());
        architecture.setUpdatedAt(now());
        architecture.setUpdatedBy(currentUser());

        return mapper.toResponse(repository.save(architecture));

    }

}