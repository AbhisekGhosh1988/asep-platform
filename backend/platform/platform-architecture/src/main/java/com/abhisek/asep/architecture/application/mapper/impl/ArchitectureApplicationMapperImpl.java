package com.abhisek.asep.architecture.application.mapper.impl;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.application.mapper.ArchitectureApplicationMapper;
import com.abhisek.asep.architecture.domain.model.Architecture;
import org.springframework.stereotype.Component;

@Component
public class ArchitectureApplicationMapperImpl
        implements ArchitectureApplicationMapper {

    @Override
    public ArchitectureResponse toResponse(
            Architecture architecture) {

        if (architecture == null) {
            return null;
        }

        return ArchitectureResponse.builder()
                .id(architecture.getId())
                .projectId(architecture.getProjectId())
                .name(architecture.getName())
                .description(architecture.getDescription())
                .style(architecture.getStyle())
                .status(architecture.getStatus())
                .version(architecture.getVersion())
                .createdBy(architecture.getCreatedBy())
                .createdAt(architecture.getCreatedAt())
                .updatedBy(architecture.getUpdatedBy())
                .updatedAt(architecture.getUpdatedAt())
                .build();
    }

}