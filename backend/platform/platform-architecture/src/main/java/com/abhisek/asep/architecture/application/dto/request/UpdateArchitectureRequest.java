package com.abhisek.asep.architecture.application.dto.request;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArchitectureRequest {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private ArchitectureStyle style;

}