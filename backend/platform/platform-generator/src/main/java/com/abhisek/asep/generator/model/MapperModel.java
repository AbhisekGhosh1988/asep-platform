package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MapperModel extends BaseArtifactModel {

    /**
     * Source entity.
     */
    private String entity;

    /**
     * Target DTO.
     */
    private String dto;

}