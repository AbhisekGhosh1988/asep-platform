package com.abhisek.asep.architecture.application.imports.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContextImportRequest {

    @NotBlank
    private String name;

    private String description;

    private String responsibility;

    @Valid
    @Builder.Default
    private List<MicroserviceImportRequest> microservices =
            new ArrayList<>();

}