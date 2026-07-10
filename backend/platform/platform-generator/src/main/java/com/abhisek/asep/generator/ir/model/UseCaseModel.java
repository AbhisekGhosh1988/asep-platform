package com.abhisek.asep.generator.ir.model;


import com.abhisek.asep.generator.model.BaseArtifactModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UseCaseModel
        extends BaseArtifactModel {

    /**
     * Command or Query.
     */
    private UseCaseType type;

    /**
     * Request DTO.
     */
    private String requestDto;

    /**
     * Response DTO.
     */
    private String responseDto;

}