package com.abhisek.asep.architecture.application.query.service;

import com.abhisek.asep.architecture.application.query.dto.ArchitectureDetailsResponse;

public interface ArchitectureQueryService {

    ArchitectureDetailsResponse getArchitecture(String architectureId);

}