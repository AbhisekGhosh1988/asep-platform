package com.abhisek.asep.architecture.application.imports.dto.request;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectureImportRequest {

    @NotBlank
    private String projectId;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private ArchitectureStyle style;

    @Valid
    @Builder.Default
    private List<BoundedContextImportRequest> boundedContexts =
            new ArrayList<>();

}