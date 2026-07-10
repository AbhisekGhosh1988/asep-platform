package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOperationModel
        extends BaseArtifactModel {

    /**
     * Java return type.
     */
    private String returnType;

    /**
     * Method parameters.
     */
    @Builder.Default
    private List<ParameterModel> parameters =
            new ArrayList<>();

}