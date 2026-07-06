package com.abhisek.asep.architecture.application.usecase;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;

import java.util.List;

public interface ListArchitecturesUseCase {

    List<ArchitectureResponse> execute(String projectId);

}