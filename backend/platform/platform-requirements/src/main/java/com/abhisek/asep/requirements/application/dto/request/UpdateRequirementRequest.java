package com.abhisek.asep.requirements.application.dto.request;

import com.abhisek.asep.requirements.domain.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequirementRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private RequirementType type;

    @NotNull
    private Priority priority;

    @NotNull
    private Complexity complexity;

    @NotNull
    private Risk risk;

    private String parentRequirementId;

    private Set<String> tags;

}