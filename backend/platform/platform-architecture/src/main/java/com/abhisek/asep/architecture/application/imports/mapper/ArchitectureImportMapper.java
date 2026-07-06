package com.abhisek.asep.architecture.application.imports.mapper;

import com.abhisek.asep.architecture.application.imports.dto.request.ArchitectureImportRequest;
import com.abhisek.asep.architecture.domain.model.Architecture;

public interface ArchitectureImportMapper {

    Architecture toArchitecture(
            ArchitectureImportRequest request);

}