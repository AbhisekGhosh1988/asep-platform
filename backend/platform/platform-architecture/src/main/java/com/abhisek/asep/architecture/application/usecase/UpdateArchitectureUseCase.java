package com.abhisek.asep.architecture.application.usecase;

import com.abhisek.asep.architecture.application.dto.request.UpdateArchitectureRequest;
import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;

public interface UpdateArchitectureUseCase {

    ArchitectureResponse execute(
            String architectureId,
            UpdateArchitectureRequest request);

}