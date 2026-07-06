package com.abhisek.asep.architecture.application.imports.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectureImportResponse {

    private String architectureId;

    private Integer boundedContextCount;

    private Integer microserviceCount;

}