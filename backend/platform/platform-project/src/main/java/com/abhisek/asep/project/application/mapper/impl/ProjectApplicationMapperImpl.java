package com.abhisek.asep.project.application.mapper.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.domain.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectApplicationMapperImpl implements ProjectApplicationMapper {

    @Override
    public ProjectResponse toResponse(Project project) {

        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .ownerId(project.getOwnerId())
                .status(project.getStatus())
                .aiProvider(project.getAiProvider())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();

    }
}
