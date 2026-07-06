package com.abhisek.asep.architecture.application.usecase;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;

public interface GetArchitectureUseCase {

    ArchitectureResponse execute(String architectureId);

}