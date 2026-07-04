package com.abhisek.asep.project.application.dto.request;

import com.abhisek.asep.project.domain.enums.ProjectRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddProjectMemberRequest {

    @NotBlank(message = "User id is required")
    private String userId;

    @NotNull(message = "Project role is required")
    private ProjectRole role;

}