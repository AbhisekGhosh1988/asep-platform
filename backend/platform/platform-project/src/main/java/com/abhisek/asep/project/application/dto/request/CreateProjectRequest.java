package com.abhisek.asep.project.application.dto.request;

import com.abhisek.asep.project.domain.enums.AIProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProjectRequest {

    @NotBlank(message = "Project name is required")
    private String name;

    private String description;

    @NotBlank(message = "Owner id is required")
    private String ownerId;

    @NotNull(message = "AI Provider is required")
    private AIProvider aiProvider;

}