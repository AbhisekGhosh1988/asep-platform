package com.abhisek.asep.architecture.application.service;


import com.abhisek.asep.architecture.application.dto.request.CreateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.mapper.ArchitectureApplicationMapper;
import com.abhisek.asep.architecture.application.usecase.CreateArchitectureUseCase;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateArchitectureUseCaseImpl extends AbstractCreateUseCase implements CreateArchitectureUseCase {

    private final ArchitectureRepository repository;
    private final ArchitectureApplicationMapper mapper;

    @Override
    public ArchitectureResponse execute(CreateArchitectureRequest request) {

        if (repository.existsByProjectIdAndName(request.getProjectId(), request.getName())) {

            throw new IllegalArgumentException("Architecture already exists.");
        }

        Architecture architecture = Architecture.builder().id(newId()).projectId(request.getProjectId()).name(request.getName()).description(request.getDescription()).style(request.getStyle()).status(ArchitectureStatus.DRAFT).version(1).createdBy(currentUser()).createdAt(now()).updatedBy(currentUser()).updatedAt(now()).build();

        return mapper.toResponse(repository.save(architecture));
    }

}