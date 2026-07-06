package com.abhisek.asep.architecture.application.usecase;

import com.abhisek.asep.architecture.application.dto.request.CreateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;

public interface CreateArchitectureUseCase {

    ArchitectureResponse execute(CreateArchitectureRequest request);

}