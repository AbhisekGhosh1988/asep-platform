package com.abhisek.asep.project.application.mapper;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.domain.model.Project;
import org.springframework.stereotype.Component;

@Component
public interface ProjectApplicationMapper {
    ProjectResponse toResponse(Project project);
}
