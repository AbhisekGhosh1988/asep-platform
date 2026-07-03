package com.abhisek.asep.identity.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePermissionRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}