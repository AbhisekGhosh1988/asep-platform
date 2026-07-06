package com.abhisek.asep.architecture.application.service;

import com.abhisek.asep.architecture.application.usecase.DeleteArchitectureUseCase;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.core.application.usecase.AbstractDeleteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteArchitectureUseCaseImpl extends AbstractDeleteUseCase implements DeleteArchitectureUseCase {

    private final ArchitectureRepository repository;

    @Override
    public void execute(String architectureId) {

        repository.deleteById(architectureId);

    }

}