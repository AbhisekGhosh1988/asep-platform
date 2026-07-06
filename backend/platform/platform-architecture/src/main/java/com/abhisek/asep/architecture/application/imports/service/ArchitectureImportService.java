package com.abhisek.asep.architecture.application.imports.service;

import com.abhisek.asep.architecture.application.imports.dto.request.ArchitectureImportRequest;
import com.abhisek.asep.architecture.application.imports.dto.response.ArchitectureImportResponse;

public interface ArchitectureImportService {

    ArchitectureImportResponse importArchitecture(
            ArchitectureImportRequest request);

}