package com.abhisek.asep.requirements.application.dto.request;

import com.abhisek.asep.requirements.domain.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Create Requirement Request")
public class CreateRequirementRequest {

    @NotBlank
    @Schema(example = "Implement Login")
    private String title;

    @Schema(example = "System shall allow users to login using email.")
    private String description;

    @NotNull
    private RequirementType type;

    @NotNull
    private Priority priority;

    @NotNull
    private Complexity complexity;

    @Builder.Default
    private Source source = Source.MANUAL;

    @Builder.Default
    private Risk risk = Risk.LOW;

    private String parentRequirementId;

    private Set<String> tags;

}