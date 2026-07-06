package com.abhisek.asep.architecture.application.imports.mapper.impl;

import com.abhisek.asep.architecture.application.imports.dto.request.ArchitectureImportRequest;
import com.abhisek.asep.architecture.application.imports.mapper.ArchitectureImportMapper;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.model.Architecture;
import org.springframework.stereotype.Component;

@Component
public class ArchitectureImportMapperImpl
        implements ArchitectureImportMapper {

    @Override
    public Architecture toArchitecture(
            ArchitectureImportRequest request) {

        return Architecture.builder()
                .projectId(request.getProjectId())
                .name(request.getName())
                .description(request.getDescription())
                .style(request.getStyle())
                .status(ArchitectureStatus.DRAFT)
                .version(1)
                .build();

    }

}