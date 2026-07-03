package com.abhisek.asep.project.application.dto.request;

import com.abhisek.asep.project.domain.model.AIProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateProjectRequest {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private AIProvider aiProvider;

}