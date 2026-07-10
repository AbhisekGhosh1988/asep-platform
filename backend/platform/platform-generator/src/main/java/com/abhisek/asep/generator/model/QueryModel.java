package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class QueryModel
        extends BaseArtifactModel {

    /**
     * Query handler.
     */
    private String handler;

    /**
     * Response DTO.
     */
    private String responseType;

}