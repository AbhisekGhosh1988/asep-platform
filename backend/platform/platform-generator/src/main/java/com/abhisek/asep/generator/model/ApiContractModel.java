package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContractModel extends BaseArtifactModel {

    /**
     * HTTP Method.
     */
    private String method;

    /**
     * REST Path.
     */
    private String path;

    /**
     * Request DTO.
     */
    private String requestType;

    /**
     * Response DTO.
     */
    private String responseType;

}