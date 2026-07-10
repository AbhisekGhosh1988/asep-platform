package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommandModel extends BaseArtifactModel {

    /**
     * Command handler.
     */
    private String handler;

    /**
     * Request DTO.
     */
    private String requestType;

    /**
     * Response DTO.
     */
    private String responseType;

}