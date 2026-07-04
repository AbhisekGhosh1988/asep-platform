package com.abhisek.asep.project.application.dto.request;

import com.abhisek.asep.project.domain.model.ProjectAction;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectActionRequest {

    @NotNull(message = "Project action is required")
    private ProjectAction action;

}